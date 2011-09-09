package br.maplink.webservices.places.client.helper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StringHelperImplTest {

	private StringHelper helper;

	@Before
	public void setUp() {
		helper = new StringHelperImpl();
	}
	
	@Test
	public void shouldJoinACollection() {
		List<String> collection = new ArrayList<String>();
		collection.add("first");
		collection.add("second");
		
		String joinedString = helper.join(collection, "&");
		
		assertThat(joinedString)
			.isEqualTo("first&second");
	}
}
