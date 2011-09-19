package br.com.maplink.webservices.places.client.resource;

import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlaceTest {

	private XmlSerializerWrapper serializer;
	private String xmlPlaceResource;

	@Before
	public void setUp() {
		serializer = new XmlSerializerWrapperImpl();
		
		xmlPlaceResource = "<place>" +
				"<id>id</id>" +
				"<name>name</name>" +
				"<description>description</description>" +
				"<address>address</address>" +
				"<district>district</district>" +
				"<city>city</city>" +
				"<state>state</state>" +
				"<country>country</country>" +
				"<zip-code>zip-code</zip-code>" +
				"<phone>phone</phone>" +
				"<secondary-phone>secondary-phone</secondary-phone>" +
				"<category>category</category>" +
				"<sub-category>sub-category</sub-category>" +
				"<latitude>-13.435</latitude>" +
				"<longitude>-43.2314</longitude>" +
				"<distance>12.343</distance>" +
				"</place>";
	}
	
	@Test
	public void shouldDeserialize() {
		Place resource = serializer.deserialize(Place.class, xmlPlaceResource);
		
		assertThat(resource.getId())
			.isEqualTo("id");
		assertThat(resource.getName())
			.isEqualTo("name");
		assertThat(resource.getDescription())
			.isEqualTo("description");
		assertThat(resource.getAddress())
			.isEqualTo("address");
		assertThat(resource.getDistrict())
			.isEqualTo("district");
		assertThat(resource.getCity())
			.isEqualTo("city");
		assertThat(resource.getState())
			.isEqualTo("state");
		assertThat(resource.getCountry())
			.isEqualTo("country");
		assertThat(resource.getZipCode())
			.isEqualTo("zip-code");
		assertThat(resource.getPrimaryPhone())
			.isEqualTo("phone");
		assertThat(resource.getSecondaryPhone())
			.isEqualTo("secondary-phone");
		assertThat(resource.getCategory())
			.isEqualTo("category");
		assertThat(resource.getSubCategory())
			.isEqualTo("sub-category");
		assertThat(resource.getLatitude())
			.isEqualTo(-13.435D);
		assertThat(resource.getLongitude())
			.isEqualTo(-43.2314D);
		assertThat(resource.getDistance())
			.isEqualTo(12.343D);
	}
}
