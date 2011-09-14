package br.com.maplink.webservices.places.client.converter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.resource.AtomLink;
import br.com.maplink.webservices.places.client.resource.Place;
import br.com.maplink.webservices.places.client.resource.Places;

public class PlacesConverterImplTest {

	private PlacesConverter converter;
	private Places resource;
	private PlacesResult entityConverted;

	@Before
	public void setUp() {
		converter = new PlacesConverterImpl();
	}
	
	@Test
	public void shouldConvertToEntityWithNextPagePath() {
		givenResourceHasNextPagePath()
			.whenConvertingToEntity();
		
		assertThat(entityConverted.getNextPagePath())
			.isEqualTo("next-href");
	}
	
	@Test
	public void shouldConvertToEntityWithPreviousPagePath() {
		givenResourceHasPreviousPagePath()
			.whenConvertingToEntity();
		
		assertThat(entityConverted.getPreviousPagePath())
			.isEqualTo("previous-href");
	}
	
	@Test
	public void shouldConvertToEntityWithEmptyNextPagePath() {
		givenResourceHasPreviousPagePath()
			.whenConvertingToEntity();
		
		assertThat(entityConverted.getNextPagePath())
			.isEqualTo("");
	}
	
	@Test
	public void shouldConvertToEntityWithEmptyPreviousPagePath() {
		givenResourceHasNextPagePath()
		.whenConvertingToEntity();
		
		assertThat(entityConverted.getPreviousPagePath())
		.isEqualTo("");
	}
	
	@Test
	public void shouldConvertToEntityWithTotalFound() {
		givenResourceHasTotalFound()
			.whenConvertingToEntity();
		
		assertThat(entityConverted.getTotalFound())
			.isEqualTo(42);
	}
	
	@Test
	public void shouldConvertToEntityWithPlaces() {
		givenResourceHasTwoPlaces()
			.whenConvertingToEntity();
		
		assertThat(entityConverted.getPlaces())
			.hasSize(2);
		
		assertThis(entityConverted.getPlaces().get(0), resource.getPlaces().get(0));
		assertThis(entityConverted.getPlaces().get(1), resource.getPlaces().get(1));
	}

	private void assertThis(br.com.maplink.webservices.places.client.entity.Place entity, Place resource) {
		assertThat(entity.getAddress())
			.isEqualTo(resource.getAddress());
		assertThat(entity.getCategory())
			.isEqualTo(resource.getCategory());
		assertThat(entity.getCity())
			.isEqualTo(resource.getCity());
		assertThat(entity.getCountry())
			.isEqualTo(resource.getCountry());
		assertThat(entity.getDescription())
			.isEqualTo(resource.getDescription());
		assertThat(entity.getDistance())
			.isEqualTo(resource.getDistance());
		assertThat(entity.getDistrict())
			.isEqualTo(resource.getDistrict());
		assertThat(entity.getId())
			.isEqualTo(resource.getId());
		assertThat(entity.getLatitude())
			.isEqualTo(resource.getLatitude());
		assertThat(entity.getLongitude())
			.isEqualTo(resource.getLongitude());
		assertThat(entity.getName())
			.isEqualTo(resource.getName());
		assertThat(entity.getPrimaryPhone())
			.isEqualTo(resource.getPrimaryPhone());
		assertThat(entity.getSecondaryPhone())
			.isEqualTo(resource.getSecondaryPhone());
		assertThat(entity.getState())
			.isEqualTo(resource.getState());
		assertThat(entity.getSubCategory())
			.isEqualTo(resource.getSubCategory());
		assertThat(entity.getZipCode())
			.isEqualTo(resource.getZipCode());
	}
	
	private PlacesConverterImplTest givenResourceHasNextPagePath() {
		createPlaces();
		
		resource.getLinks().add(createAtomLink("next", "next-href"));
		
		return this;
	}
	
	private PlacesConverterImplTest givenResourceHasPreviousPagePath() {
		createPlaces();
		
		resource.getLinks().add(createAtomLink("previous", "previous-href"));
		
		return this;
	}
	
	private PlacesConverterImplTest givenResourceHasTotalFound() {
		createPlaces();
		
		resource.setTotalFound(42);
		
		return this;
	}
	
	private PlacesConverterImplTest givenResourceHasTwoPlaces() {
		createPlaces();
		
		resource.getPlaces().add(createPlace());
		resource.getPlaces().add(new Place());
		
		return this;
	}

	private Place createPlace() {
		Place entity = new Place();
		entity.setAddress("address");
		entity.setCategory("category");
		entity.setCity("city");
		entity.setCountry("country");
		entity.setDescription("description");
		entity.setDistance(42.43);
		entity.setDistrict("district");
		entity.setId("id");
		entity.setLatitude(-12.34D);
		entity.setLongitude(43.21D);
		entity.setName("name");
		entity.setPrimaryPhone("primary-phone");
		entity.setSecondaryPhone("secondary-phone");
		entity.setState("state");
		entity.setSubCategory("sub-category");
		entity.setZipCode("zip-code");
		
		return entity;
	}

	private void whenConvertingToEntity() {
		entityConverted = converter.toEntity(resource);
	}
	
	private void createPlaces() {
		resource = new Places();
	}
	
	private AtomLink createAtomLink(String rel, String href) {
		AtomLink atomLink = new AtomLink();
		atomLink.setRel(rel);
		atomLink.setHref(href);
		return atomLink;
	}
}
