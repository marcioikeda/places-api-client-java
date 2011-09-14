package br.com.maplink.webservices.places.client.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;

import br.com.maplink.webservices.places.client.builder.RequestAuthorizationBuilder;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.RequestAuthorization;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;
import br.com.maplink.webservices.places.client.resource.Category;
import br.com.maplink.webservices.places.client.service.HttpResponseRetriever;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetrieverImpl;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.tealdi.httpclient.Header;
import br.com.tealdi.httpclient.Response;

public class ResourceRequestRetrieverImplTest {

	private ResourceRequestRetriever retriever;
	private RequestAuthorizationBuilder mockedRequestAuthorizationBuilder;
	private HttpResponseRetriever mockedHttpResponseRetriever;
	private XmlSerializerWrapper mockedXmlSerializerWrapper;
	private Category resourceRetrieved;
	private Category resource;
	private ApiRequest apiRequest;
	private RequestAuthorization requestAuthorizationBuit;
	private Response validResponseRetrieved;
	private Response invalidResponseRetrieved;

	@Before
	public void setUp() {
		apiRequest = new ApiRequest();
		
		mockedRequestAuthorizationBuilder = mock(RequestAuthorizationBuilder.class);
		mockedHttpResponseRetriever = mock(HttpResponseRetriever.class);
		mockedXmlSerializerWrapper = mock(XmlSerializerWrapper.class);
		
		retriever = new ResourceRequestRetrieverImpl(
				mockedRequestAuthorizationBuilder, 
				mockedHttpResponseRetriever, 
				mockedXmlSerializerWrapper);
	}
	
	@Test
	public void shouldRetrieveResource() throws Exception {
		givenRequestAuthorizationWasBuilt()
			.andValidResponseWereRetrieved()
			.andResponseWasSerialized()
			.whenRetrievingResource();
			
		assertThat(resource)
			.isEqualTo(resourceRetrieved);
	}
	
	@Test
	public void shouldBuildRequestAuthorizationWhenRetrievingResource() throws Exception {
		givenRequestAuthorizationWasBuilt()
			.andValidResponseWereRetrieved()
			.andResponseWasSerialized()
			.whenRetrievingResource();
		
		verify(mockedRequestAuthorizationBuilder, times(1))
			.build(apiRequest);
	}
	
	@Test
	public void shouldRetrieveHttpResponseWhenRetrievingResource() throws Exception {
		givenRequestAuthorizationWasBuilt()
			.andValidResponseWereRetrieved()
			.andResponseWasSerialized()
			.whenRetrievingResource();
		
		verify(mockedHttpResponseRetriever, times(1))
			.retrieveFor(requestAuthorizationBuit);
	}
	
	@Test
	public void shouldDeserializeResponseBodyWhenRetrievingResource() throws Exception {
		givenRequestAuthorizationWasBuilt()
			.andValidResponseWereRetrieved()
			.andResponseWasSerialized()
			.whenRetrievingResource();
		
		verify(mockedXmlSerializerWrapper, times(1))
			.deserialize(Category.class, validResponseRetrieved.getBody());	
	}
	
	@Test(expected=PlacesApiClientRequestException.class)
	public void shouldThrowExceptionWhenRetrievingResourceWithAInvalidResponse() throws Exception {
		givenRequestAuthorizationWasBuilt()
			.andInvalidResponseWereRetrieved()
			.whenRetrievingResource();
	}

	private ResourceRequestRetrieverImplTest andInvalidResponseWereRetrieved() throws Exception {
		invalidResponseRetrieved = new Response(400, "body", new Header());
		
		when(mockedHttpResponseRetriever.retrieveFor(isA(RequestAuthorization.class)))
			.thenReturn(invalidResponseRetrieved);
		
		return this;
	}

	private void whenRetrievingResource() throws Exception {
		resource = retriever.retrieve(Category.class, apiRequest);
	}

	private ResourceRequestRetrieverImplTest andResponseWasSerialized() {
		resourceRetrieved = new Category();
		
		when(mockedXmlSerializerWrapper.deserialize(eq(Category.class), anyString()))
			.thenReturn(resourceRetrieved);
		
		return this;
	}

	private ResourceRequestRetrieverImplTest andValidResponseWereRetrieved() throws Exception {
		validResponseRetrieved = new Response(200, "body", new Header());
		
		when(mockedHttpResponseRetriever.retrieveFor(isA(RequestAuthorization.class)))
			.thenReturn(validResponseRetrieved);
		
		return this;
	}

	private ResourceRequestRetrieverImplTest givenRequestAuthorizationWasBuilt() throws Exception {		
		requestAuthorizationBuit = new RequestAuthorization();
		
		when(mockedRequestAuthorizationBuilder.build(isA(ApiRequest.class)))
			.thenReturn(requestAuthorizationBuit);

		return this;
	}
}
