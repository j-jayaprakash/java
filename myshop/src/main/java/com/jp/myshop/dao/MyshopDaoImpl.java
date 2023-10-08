package com.jp.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jp.myshop.dto.OrderDto;
import com.jp.myshop.dto.ProductDto;
import com.jp.myshop.entity.Product;
import com.jp.myshop.entity.SoldItemInfo;
import com.jp.myshop.entity.StockInfo;
import com.jp.myshop.util.SessonFactoryGen;

public class MyshopDaoImpl implements MyShopDao {

	@Override
	public void addProduct(ProductDto productDto) {
		// product
		Product product = new Product();

		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());

		LocalDateTime dt = LocalDateTime.now();
		product.setCreatedDate(dt);

		Session sessionProduct = SessonFactoryGen.getSessionFactory().openSession();

		Transaction stp = sessionProduct.beginTransaction();
		Product savedProduct = (Product) sessionProduct.merge(product);
		stp.commit();

		// stock

		StockInfo stockInfo = new StockInfo();

		long altKey = savedProduct.getAltKey();

		stockInfo.setProductId(altKey);
		stockInfo.setStockNumber(productDto.getQuantity());

		Session sessionStock = SessonFactoryGen.getSessionFactory().openSession();

		Transaction sts = sessionStock.beginTransaction();

		sessionStock.save(stockInfo);

		sts.commit();

	}

	@Override
	public void sellItem(List<OrderDto> products) {

		Session stockSesson = SessonFactoryGen.getSessionFactory().openSession();

		for (OrderDto prod : products) {

			Product product = (Product) getById(prod.getProductId());

			product.setModifiedDate(LocalDate.now().toString());
			Session productSession = SessonFactoryGen.getSessionFactory().openSession();
			Transaction pt = productSession.beginTransaction();
			productSession.merge(product);
			pt.commit();

			String s = "from StockInfo where productId=:pid";

			Query q = stockSesson.createQuery(s);
			q.setParameter("pid", product.getAltKey());
			List resultList = q.getResultList();

			for (Object orderDto : resultList) {
				StockInfo sto = (StockInfo) orderDto;
				sto.setStockNumber(sto.getStockNumber() - prod.getQuantity());
				Transaction st = stockSesson.beginTransaction();
				stockSesson.merge(sto);
				st.commit();
			}

			Session orderSession = SessonFactoryGen.getSessionFactory().openSession();
			Transaction ot = orderSession.beginTransaction();

			SoldItemInfo orderRecord = new SoldItemInfo();

			orderRecord.setCreatedData(LocalDate.now().toString());
			orderRecord.setProductId(prod.getProductId());
			orderRecord.setPurchaseId((int) (Math.random() * 100000000));
			orderRecord.setQuantity(prod.getQuantity());
			orderRecord.setTotalPrice(product.getPrice() * prod.getQuantity());

			orderSession.save(orderRecord);
			ot.commit();

		}

	}

	@Override
	public void getSoldProductForCurrentDate(long productId) {

		Session orderSession = SessonFactoryGen.getSessionFactory().openSession();
		String s = "from SoldItemInfo where createdDate=:date";

		Query q = orderSession.createQuery(s);
		q.setParameter("date", LocalDate.now().toString());
		List resultList = q.getResultList();

		for (Object object : resultList) {

			System.out.println(object);
		}

	}

	@Override
	public Object getById(long altKey) {

		Session prodSession = SessonFactoryGen.getSessionFactory().openSession();

		Product prod = (Product) prodSession.find(Product.class, altKey);
		return prod;

	}

}
