package br.com.maplink.webservices.places.client;


import br.com.maplink.webservices.places.client.builder.ApiRequestBuilder;
import br.com.maplink.webservices.places.client.converter.CategoryConverter;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.resource.Categories;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class CategorySearcherImplTest {

	private static final String HOST = "host";
	private static final String LICENSE_LOGIN = "license-login";
	private static final String LICENSE_KEY = "license-key";
	private CategoryConverter mockedCategoryConverter;
	private ResourceRequestRetriever mockedResourceRequestRetriever;
	private ApiRequestBuilder mockedApiRequestBuilder;
	private CategorySearcher searcher;
	private ApiRequest apiRequestBuilt;
	private Categories resourceRetrieved;
	private List<br.com.maplink.webservices.places.client.entity.Category> categoriesConverted;
	private PlacesApiRequest placeApiRequest;
	private List<br.com.maplink.webservices.places.client.entity.Category> categoriesFound;

	@Before
	public void setUp() {
		mockedApiRequestBuilder = mock(ApiRequestBuilder.class);
		mockedResourceRequestRetriever = mock(ResourceRequestRetriever.class);
		mockedCategoryConverter = mock(CategoryConverter.class);
		
		searcher = new CategorySearcherImpl(
				mockedApiRequestBuilder,
				mockedResourceRequestRetriever,
				mockedCategoryConverter);
	}
	
	@Test
	public void shouldRetrieveAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		assertThat(categoriesFound)
			.isEqualTo(categoriesConverted);
	}
	
	@Test
	public void shouldBuildApiRequestWithHostWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedApiRequestBuilder, times(1))
			.withHost(HOST);
	}
	
	@Test
	public void shouldBuildApiRequestWithLicenseInfoWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedApiRequestBuilder, times(1))
			.withLicenseInfo(LICENSE_LOGIN, LICENSE_KEY);
	}
	
	@Test
	public void shouldBuildApiRequestWithPathWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedApiRequestBuilder, times(1))
			.withPath("/categories");
	}
	
	@Test
	public void shouldBuildApiRequestWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedApiRequestBuilder, times(1))
			.build();
	}
	
	@Test
	public void shouldRetrieveResourceWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedResourceRequestRetriever, times(1))
			.retrieve(Categories.class, apiRequestBuilt);
	}
	
	@Test
	public void shouldConvertResourceWhenRetrievingAllCategories() throws Exception {
		givenApiRequestWasBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingAllCategories();
		
		verify(mockedCategoryConverter, times(1))
			.toEntity(resourceRetrieved);
	}
	
	private void whenSearchingAllCategories() throws Exception  {
		placeApiRequest = new PlacesApiRequest();
		placeApiRequest.setHost(HOST);
		placeApiRequest.setLicenseLogin(LICENSE_LOGIN);
		placeApiRequest.setLicenseKey(LICENSE_KEY);
		
		categoriesFound = searcher.all(placeApiRequest);
	}

	private CategorySearcherImplTest givenApiRequestWasBuilt() {
		apiRequestBuilt = new ApiRequest();
		
		when(mockedApiRequestBuilder.withHost(anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withPath(anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withLicenseInfo(anyString(), anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.build())
			.thenReturn(apiRequestBuilt);
		
		return this;
	}
	
	private CategorySearcherImplTest andResourceWasRetrieved() throws Exception {
		resourceRetrieved = new Categories();
		
		when(mockedResourceRequestRetriever.retrieve(eq(Categories.class), isA(ApiRequest.class)))
			.thenReturn(resourceRetrieved);
		
		return this;
	}
	
	private CategorySearcherImplTest andResourceWasConverted() throws Exception {
		categoriesConverted = new ArrayList<br.com.maplink.webservices.places.client.entity.Category>();
		
		when(mockedCategoryConverter.toEntity(isA(Categories.class)))
			.thenReturn(categoriesConverted);
		
		return this;
	}
}
