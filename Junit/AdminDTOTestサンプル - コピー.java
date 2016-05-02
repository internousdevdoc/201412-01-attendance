package junit.test;

import static org.junit.Assert.*;
import jp.co.ec_10.dto.AdminDTO;

import org.junit.Before;
import org.junit.Test;

public class AdminDTOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAdmin_id() {
		String admin_id="12345678";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_id("12345678");
		assertEquals(admin_id, expected.getAdmin_id());
	}

	@Test
	public void testGetAdmin_pass() {
		String admin_pass="commando";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_pass("commando");
		assertEquals(admin_pass, expected.getAdmin_pass());
	}

	@Test
	public void testGetAdmin_name() {
		String admin_name="メイトリックス";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_name("メイトリックス");
		assertEquals(admin_name, expected.getAdmin_name());
	}

	@Test
	public void testGetItem_id() {
		String item_id="1";
		AdminDTO expected = new AdminDTO();
		expected.setItem_id("1");
		assertEquals(item_id, expected.getItem_id());
	}

	@Test
	public void testGetItem_name() {
		String item_name="日本酒１";
		AdminDTO expected = new AdminDTO();
		expected.setItem_name("日本酒１");
		assertEquals(item_name, expected.getItem_name());
	}

	@Test
	public void testGetItem_price() {
		String item_price="2000";
		AdminDTO expected = new AdminDTO();
		expected.setItem_price("2000");
		assertEquals(item_price, expected.getItem_price());
	}

	@Test
	public void testGetItem_stock() {
		String item_stock="20";
		AdminDTO expected = new AdminDTO();
		expected.setItem_stock("20");
		assertEquals(item_stock, expected.getItem_stock());
	}

	@Test
	public void testGetItem_img() {
		String item_img="img/noimage.jpg";
		AdminDTO expected = new AdminDTO();
		expected.setItem_img("img/noimage.jpg");
		assertEquals(item_img, expected.getItem_img());
	}

	@Test
	public void testGetOrder_id() {
		String order_id="1";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_id("1");
		assertEquals(order_id, expected.getOrder_id());
	}

	@Test
	public void testGetOrder_count() {
		String order_count="5";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_count("5");
		assertEquals(order_count, expected.getOrder_count());
	}

	@Test
	public void testGetOrder_customer() {
		String customer="ベネット";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_customer("ベネット");
		assertEquals(customer, expected.getOrder_customer());
	}

	@Test
	public void testGetOrder_post() {
		String post="郵便番号";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_post("郵便番号");
		assertEquals(post, expected.getOrder_post());
	}

	@Test
	public void testGetOrder_mail() {
		String order_mail="アドレス";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_mail("アドレス");
		assertEquals(order_mail, expected.getOrder_mail());
	}

	@Test
	public void testGetOrder_destination() {
		String destination="住所";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_destination("住所");
		assertEquals(destination, expected.getOrder_destination());
	}

	@Test
	public void testGetOrder_phone() {
		String order_phone="電話番号";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_phone("電話番号");
		assertEquals(order_phone, expected.getOrder_phone());
	}

	@Test
	public void testGetOrder_day() {
		String order_day="購入日";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_day("購入日");
		assertEquals(order_day, expected.getOrder_day());
	}

	@Test
	public void testSetAdmin_id() {
		String admin_id="12345678";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_id("12345678");
		String value = expected.getAdmin_id();
		assertEquals(value, admin_id);
	}

	@Test
	public void testSetAdmin_pass() {
		String admin_pass="commando";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_pass("commando");
		String value = expected.getAdmin_pass();
		assertEquals(value, admin_pass);
	}

	@Test
	public void testSetAdmin_name() {
		String admin_name="メイトリックス";
		AdminDTO expected = new AdminDTO();
		expected.setAdmin_name("メイトリックス");
		String value = expected.getAdmin_name();
		assertEquals(value, admin_name);
	}

	@Test
	public void testSetItem_id() {
		String item_id="1";
		AdminDTO expected = new AdminDTO();
		expected.setItem_id("1");
		String value = expected.getItem_id();
		assertEquals(value, item_id);
	}

	@Test
	public void testSetItem_name() {
		String item_name="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setItem_name("テスト");
		String value = expected.getItem_name();
		assertEquals(value, item_name);
	}

	@Test
	public void testSetItem_price() {
		String item_price="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setItem_price("テスト");
		String value = expected.getItem_price();
		assertEquals(value, item_price);
	}

	@Test
	public void testSetItem_stock() {
		String item_stock="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setItem_stock("テスト");
		String value = expected.getItem_stock();
		assertEquals(value, item_stock);
	}

	@Test
	public void testSetItem_img() {
		String item_img="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setItem_img("テスト");
		String value = expected.getItem_img();
		assertEquals(value, item_img);
	}

	@Test
	public void testSetOrder_id() {
		String order_id="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_id("テスト");
		String value = expected.getOrder_id();
		assertEquals(value, order_id);
	}

	@Test
	public void testSetOrder_count() {
		String order_count="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_count("テスト");
		String value = expected.getOrder_count();
		assertEquals(value, order_count);
	}

	@Test
	public void testSetOrder_customer() {
		String order_customer="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_customer("テスト");
		String value = expected.getOrder_customer();
		assertEquals(value, order_customer);
	}

	@Test
	public void testSetOrder_post() {
		String order_post="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_post("テスト");
		String value = expected.getOrder_post();
		assertEquals(value, order_post);
	}

	@Test
	public void testSetOrder_mail() {
		String order_mail="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_mail("テスト");
		String value = expected.getOrder_mail();
		assertEquals(value, order_mail);
	}

	@Test
	public void testSetOrder_destination() {
		String order_destination="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_destination("テスト");
		String value = expected.getOrder_destination();
		assertEquals(value, order_destination);
	}

	@Test
	public void testSetOrder_day() {
		String order_day="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_day("テスト");
		String value = expected.getOrder_day();
		assertEquals(value, order_day);
	}

	@Test
	public void testSetOrder_phone() {
		String order_phone="テスト";
		AdminDTO expected = new AdminDTO();
		expected.setOrder_phone("テスト");
		String value = expected.getOrder_phone();
		assertEquals(value, order_phone);
	}

}
