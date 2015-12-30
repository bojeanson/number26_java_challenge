import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import com.number26.restAPI.challenge.Transaction;
import com.number26.restAPI.challenge.TransactionResource;


public class TransactionResourceTest {
	public Transaction transaction1;
	public Transaction transaction2;
	public Transaction transaction3;
	public Transaction transaction4;
	public Transaction transaction5;
	public TransactionResource resource;
	
	@Before
	public void createTransaction() {
		transaction1 = new Transaction(1000,"shopping");
		transaction2 = new Transaction(2000,"shopping",1);
		transaction3 = new Transaction(3000,"shopping",1);
		transaction4 = new Transaction(6500,"accommodation");
		transaction5 = new Transaction(7500,"accommodation",4);
		resource = new TransactionResource();
	}
	
	@Test
	public void testCreateTransaction() {
		Response response = resource.createTransaction(1, transaction1);
		assertEquals(response.getStatus(), 200);
	}
	
	@Test
	public void testGetTransaction() {
		resource.createTransaction(1, transaction1);
		Transaction transaction = resource.getTransaction(1);
		assertEquals(transaction.getType(), "shopping");
		assertThat(transaction.getAmount(), IsEqual.equalTo(1000.0));
	}
}
