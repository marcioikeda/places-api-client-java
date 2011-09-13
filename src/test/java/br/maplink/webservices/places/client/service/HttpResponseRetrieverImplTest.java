package br.maplink.webservices.places.client.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.tealdi.httpclient.Header;
import br.com.tealdi.httpclient.Request;
import br.com.tealdi.httpclient.RequestClient;
import br.com.tealdi.httpclient.Response;
import br.com.tealdi.httpclient.builder.ABuilderForRequest;
import br.maplink.webservices.places.client.entity.RequestAuthorization;

public class HttpResponseRetrieverImplTest {

	private static final String URI = "uri";
	private static final String AUTHORIZATION = "authorization";
	private static final String DATE = "date";
	private ABuilderForRequest mockedRequestBuilder;
	private RequestClient mockedHttpClient;
	private HttpResponseRetriever retriever;
	private RequestAuthorization requestAuthorization;
	private Response responseRetrievedFromClient;
	private Request requestBuilt;
	private Response responseRetrieved;

	@Before
	public void setUp() {
		requestAuthorization = new RequestAuthorization();
		requestAuthorization.setUri(URI);
		requestAuthorization.setAuthorization(AUTHORIZATION);
		requestAuthorization.setDateInRfc1132(DATE);
		
		mockedRequestBuilder = mock(ABuilderForRequest.class);
		mockedHttpClient = mock(RequestClient.class);
		
		retriever = new HttpResponseRetrieverImpl(mockedRequestBuilder, mockedHttpClient);
	}
	
	@Test
	public void shouldRetrieveHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		assertThat(responseRetrieved)
			.isEqualTo(responseRetrievedFromClient);
	}

	@Test
	public void shouldBuildRequestWithUriWhenRetrievingHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		verify(mockedRequestBuilder, times(1))
			.forThis(URI);
	}
	
	@Test
	public void shouldBuildRequestWithContentTypeHeaderWhenRetrievingHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		verify(mockedRequestBuilder, times(1))
			.withHeaderProperty("Content-Type", "application/xml");
	}
	
	@Test
	public void shouldBuildRequestWithAcceptHeaderWhenRetrievingHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		verify(mockedRequestBuilder, times(1))
			.withHeaderProperty("Accept", "application/xml");
	}
	
	@Test
	public void shouldBuildRequestWithXMaplinkDateHeaderWhenRetrievingHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		verify(mockedRequestBuilder, times(1))
			.withHeaderProperty("X-Maplink-Date", DATE);
	}
	
	@Test
	public void shouldBuildRequestWithAuthorizationHeaderWhenRetrievingHttpResponse() throws MalformedURLException, IOException {
		givenHttpRequestWasBuilt()
			.andResponseWereRetrieved()
			.whenRetrievingHttpResponse();
		
		verify(mockedRequestBuilder, times(1))
			.withHeaderProperty("Authorization", AUTHORIZATION);
	}
	
	private void whenRetrievingHttpResponse() throws MalformedURLException, IOException {
		responseRetrieved = retriever.retrieveFor(requestAuthorization);
	}

	private HttpResponseRetrieverImplTest andResponseWereRetrieved() throws MalformedURLException, IOException {
		responseRetrievedFromClient = new Response(200, "", new Header());
		
		when(mockedHttpClient.doGet(isA(Request.class)))
			.thenReturn(responseRetrievedFromClient);
		
		return this;
	}

	private HttpResponseRetrieverImplTest givenHttpRequestWasBuilt() {
		requestBuilt = new Request(URI);
		
		when(mockedRequestBuilder.forThis(anyString()))
			.thenReturn(mockedRequestBuilder);
		when(mockedRequestBuilder.withHeaderProperty(anyString(), anyString()))
			.thenReturn(mockedRequestBuilder);
		when(mockedRequestBuilder.instance())
			.thenReturn(requestBuilt);
		
		return this;
	}
}
