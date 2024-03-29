package br.com.maplink.webservices.places.client;

import br.com.maplink.webservices.places.client.argument.PlaceRequestArgument;
import br.com.maplink.webservices.places.client.builder.ApiRequestBuilder;
import br.com.maplink.webservices.places.client.converter.PlacesConverter;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.resource.Places;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class PlaceSearcherImplTest {

	private static final String KEY = "key";
	private static final String LOGIN = "login";
	private static final String HOST = "host";
	private static final double RADIUS = 12.34;
	private static final double LATITUDE = -26.43;
	private static final double LONGITUDE = 46.41;
	private static final String TERM = "term";
	private static final int CATEGORY = 42;
	private static final String PAGINATION_PATH = "pagination-path";
	private PlaceSearcher searcher;
	private ApiRequestBuilder mockedApiRequestBuilder;
	private ResourceRequestRetriever mockedResourceRequestRetriever;
	private PlacesConverter mockedPlacesConverter;
	private PlacesResult placesFound;
	private PlacesApiRequest placesApiRequest;
	private PlaceRequestArgument placeRequestArgumenent;
	private ApiRequest apiRequestBuilt;
	private PlacesResult convertedPlaces;
	private Places resourceRetrieved;

	@Before
	public void setUp() {
		placesApiRequest = new PlacesApiRequest();
		placesApiRequest.setHost(HOST);
		placesApiRequest.setLicenseLogin(LOGIN);
		placesApiRequest.setLicenseKey(KEY);
		
		mockedApiRequestBuilder = mock(ApiRequestBuilder.class);
		mockedResourceRequestRetriever = mock(ResourceRequestRetriever.class);
		mockedPlacesConverter = mock(PlacesConverter.class);
		
		searcher = new PlaceSearcherImpl(
				mockedApiRequestBuilder, 
				mockedResourceRequestRetriever, 
				mockedPlacesConverter);
	}
	
	@Test
	public void shouldSearchPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		assertThat(placesFound)
			.isEqualTo(convertedPlaces);
	}

	@Test
	public void shouldSearchPlacesByTerm() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByTerm();

		assertThat(placesFound)
			.isEqualTo(convertedPlaces);
	}

	@Test
	public void shouldSearchPlacesByCategory() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByCategory();

		assertThat(placesFound)
			.isEqualTo(convertedPlaces);
	}
	
	@Test
	public void shouldCreateApiRequestWithHostWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withHost(HOST);
	}
	
	@Test
	public void shouldCreateApiRequestWithPathWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withPath("/places/byradius");
	}
	
	@Test
	public void shouldCreateApiRequestWithLicenseInfoWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withLicenseInfo(LOGIN, KEY);
	}
	
	@Test
	public void shouldCreateApiRequestWithRadiusWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withParameter("radius", Double.toString(RADIUS));
	}
	
	@Test
	public void shouldCreateApiRequestWithLatitudeWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withParameter("latitude", Double.toString(LATITUDE));
	}
	
	@Test
	public void shouldCreateApiRequestWithLongitudeWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.withParameter("longitude", Double.toString(LONGITUDE));
	}
	
	@Test
	public void shouldCreateApiRequestWithTermWhenSearchingPlacesByRadiusWithFilterTerm() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadiusWithFilterTerm();
		
		verify(mockedApiRequestBuilder, times(1))
			.withParameter("term", TERM);
	}
	
	@Test
	public void shouldCreateApiRequestWithoutTermWhenSearchingPlacesByRadiusWithoutFilterTerm() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(0))
			.withParameter("term", TERM);
	}
	
	@Test
	public void shouldCreateApiRequestWithCategoryWhenSearchingPlacesByRadiusWithFilterCategory() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadiusWithFilterCategory();
		
		verify(mockedApiRequestBuilder, times(1))
			.withParameter("category", Integer.toString(CATEGORY));
	}
	
	@Test
	public void shouldCreateApiRequestWithoutCategoryWhenSearchingPlacesByRadiusWithoutFilterCategory() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(0))
			.withParameter("category", Integer.toString(CATEGORY));
	}
	
	@Test
	public void shouldBuildApiRequestWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedApiRequestBuilder, times(1))
			.build();
	}
	
	@Test
	public void shouldRetrieveResourceWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedResourceRequestRetriever, times(1))
			.retrieve(Places.class, apiRequestBuilt);
	}
	
	@Test
	public void shouldConvertResourceWhenSerachingPlacesByRadius() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedPlacesConverter, times(1))
			.toEntity(resourceRetrieved);
	}

	@Test
	public void shouldSearchPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesForPaginationPath();
		
		assertThat(placesFound)
			.isEqualTo(convertedPlaces);
	}
	
	@Test
	public void shouldCreateApiRequestWithHostWhenSearchingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesForPaginationPath();
		
		verify(mockedApiRequestBuilder, times(1))
			.withHost(HOST);
	}
	
	@Test
	public void shouldCreateApiRequestWithPathAndQueryWhenSearchingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
		.andResourceWasRetrieved()
		.andResourceWasConverted()
		.whenSearchingPlacesForPaginationPath();
		
		verify(mockedApiRequestBuilder, times(1))
			.withPathAndQuery(PAGINATION_PATH);
	}
	
	@Test
	public void shouldCreateApiRequestWithoutPathWhenSearchingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesForPaginationPath();
		
		verify(mockedApiRequestBuilder, times(0))
			.withPath("/places/byradius");
	}

	@Test
	public void shouldBuildApiRequestWhenSerachingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesForPaginationPath();
		
		verify(mockedApiRequestBuilder, times(1))
			.build();
	}
	
	@Test
	public void shouldRetrieveResourceWhenSerachingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesForPaginationPath();
		
		verify(mockedResourceRequestRetriever, times(1))
			.retrieve(Places.class, apiRequestBuilt);
	}
	
	@Test
	public void shouldConvertResourceWhenSerachingPlacesForPaginationPath() throws Exception {
		givenApiRequestCanBeBuilt()
			.andResourceWasRetrieved()
			.andResourceWasConverted()
			.whenSearchingPlacesByRadius();
		
		verify(mockedPlacesConverter, times(1))
			.toEntity(resourceRetrieved);
	}
	
	private PlaceSearcherImplTest givenApiRequestCanBeBuilt() {
		apiRequestBuilt = new ApiRequest();
		
		when(mockedApiRequestBuilder.withHost(anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withLicenseInfo(anyString(), anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withPath(anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withPathAndQuery(anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.withParameter(anyString(), anyString()))
			.thenReturn(mockedApiRequestBuilder);
		when(mockedApiRequestBuilder.build())
			.thenReturn(apiRequestBuilt);
		
		return this;
	}
	
	private PlaceSearcherImplTest andResourceWasRetrieved() throws Exception {
		resourceRetrieved = new Places();
		
		when(mockedResourceRequestRetriever.retrieve(eq(Places.class), isA(ApiRequest.class)))
			.thenReturn(resourceRetrieved);
		
		return this;
	}
	
	private PlaceSearcherImplTest andResourceWasConverted() {
		when(mockedPlacesConverter.toEntity(isA(Places.class)))
			.thenReturn(convertedPlaces);
		
		return this;
	}
	
	private void whenSearchingPlacesByRadius() throws Exception {
		createRequestForSearchByRadius();
		
		placesFound = searcher.byRadius(placesApiRequest, placeRequestArgumenent);
	}

	private void whenSearchingPlacesByTerm() throws Exception {
		createRequestForSearchByTerm();

		placesFound = searcher.byTerm(placesApiRequest, placeRequestArgumenent);
	}

	private void whenSearchingPlacesByCategory() throws Exception {
		createRequestForSearchByCategory();

        placesFound = searcher.byCategory(placesApiRequest, placeRequestArgumenent);
	}
	
	private void whenSearchingPlacesForPaginationPath() throws Exception {
		createRequestForSearchByRadius();
		
		placesFound = searcher.forPaginationPath(placesApiRequest, PAGINATION_PATH);
	}
	
	private void whenSearchingPlacesByRadiusWithFilterTerm() throws Exception {
		createRequestForSearchByRadius();
		placeRequestArgumenent.setTerm(TERM);
		
		placesFound = searcher.byRadius(placesApiRequest, placeRequestArgumenent);
	}
	
	private void whenSearchingPlacesByRadiusWithFilterCategory() throws Exception {
		createRequestForSearchByRadius();
		placeRequestArgumenent.setCategory(CATEGORY);
		
		placesFound = searcher.byRadius(placesApiRequest, placeRequestArgumenent);
	}

	private void createRequestForSearchByRadius() {
		placeRequestArgumenent = new PlaceRequestArgument();
		placeRequestArgumenent.setRadius(RADIUS);
		placeRequestArgumenent.setLatitude(LATITUDE);
		placeRequestArgumenent.setLongitude(LONGITUDE);
	}

	private void createRequestForSearchByTerm() {
		placeRequestArgumenent = new PlaceRequestArgument();
		placeRequestArgumenent.setTerm(TERM);
	}

    private void createRequestForSearchByCategory() {
		placeRequestArgumenent = new PlaceRequestArgument();
		placeRequestArgumenent.setCategory(CATEGORY);
	}
}
