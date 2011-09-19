package br.com.maplink.webservices.places.client;

import br.com.maplink.webservices.places.client.argument.PlaceRequestArgument;
import br.com.maplink.webservices.places.client.builder.*;
import br.com.maplink.webservices.places.client.converter.DateConverterImpl;
import br.com.maplink.webservices.places.client.converter.PlacesConverter;
import br.com.maplink.webservices.places.client.converter.PlacesConverterImpl;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;
import br.com.maplink.webservices.places.client.helper.Base64EncoderImpl;
import br.com.maplink.webservices.places.client.helper.ClockImpl;
import br.com.maplink.webservices.places.client.helper.HexHmacSha1GeneratorImpl;
import br.com.maplink.webservices.places.client.resource.Places;
import br.com.maplink.webservices.places.client.service.HttpResponseRetrieverImpl;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetrieverImpl;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import br.com.tealdi.httpclient.HttpClient;
import br.com.tealdi.httpclient.builder.RequestBuilder;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PlaceSearcherImpl implements PlaceSearcher {
	
	private final ApiRequestBuilder apiRequestBuilder;
	private final ResourceRequestRetriever resourceRetriever;
	private final PlacesConverter placesConverter;

	public PlaceSearcherImpl() {
		this(
				new ApiRequestBuilderImpl(),
				new ResourceRequestRetrieverImpl(
						new RequestAuthorizationBuilderImpl(
								new AuthorizationRfc1132DateGeneratorImpl(new ClockImpl(), new DateConverterImpl()),
								new UriBuilderImpl(new QueryStringBuilderImpl()),
								new AuthorizationHeaderBuilderImpl(new HexHmacSha1GeneratorImpl(), new Base64EncoderImpl())),
						new HttpResponseRetrieverImpl(new RequestBuilder(), new HttpClient()),
						new XmlSerializerWrapperImpl()),
				new PlacesConverterImpl());
	}
	
	public PlaceSearcherImpl(
			ApiRequestBuilder apiRequestBuilder,
			ResourceRequestRetriever resourceRetriever,
			PlacesConverter placesConverter) {
				this.apiRequestBuilder = apiRequestBuilder;
				this.resourceRetriever = resourceRetriever;
				this.placesConverter = placesConverter;
	}

	public PlacesResult byRadius(PlacesApiRequest placesApiRequest, PlaceRequestArgument requestArgument)
		throws InvalidKeyException, NoSuchAlgorithmException, IOException, PlacesApiClientRequestException {
		ApiRequest requestBuilt =
			createRequest(placesApiRequest, requestArgument);
			
		return convertThisRequestIntoEntity(requestBuilt);
	}


	public PlacesResult forPaginationPath(PlacesApiRequest placesApiRequest, String paginationPath) 
	throws InvalidKeyException, NoSuchAlgorithmException, IOException, PlacesApiClientRequestException {
		ApiRequestBuilder builder = createMinimalApiRequestBuilder(placesApiRequest);
		
		return convertThisRequestIntoEntity(
				builder.withPathAndQuery(paginationPath).build());
	}

	private PlacesResult convertThisRequestIntoEntity(ApiRequest requestBuilt)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException {
		return placesConverter.toEntity(
					resourceRetriever.retrieve(Places.class, requestBuilt));
	}
		
	private ApiRequest createRequest(PlacesApiRequest placesApiRequest, PlaceRequestArgument placeRequestArgumenent) {
		ApiRequestBuilder builder = createDefaultApiRequestBuilder(placesApiRequest, placeRequestArgumenent);
		insertFilterTerm(builder, placeRequestArgumenent);
		insertFilterCategory(builder, placeRequestArgumenent);
		
		return builder.build();
	}

	private void insertFilterTerm(
			ApiRequestBuilder builder,
			PlaceRequestArgument placeRequestArgumenent) {
		String filterTerm = placeRequestArgumenent.getFilterTerm();
		
		if(filterTerm != null && !filterTerm.equals("")) {
			builder.withParameter("term", filterTerm);
		}
	}
	
	private void insertFilterCategory(
			ApiRequestBuilder builder,
			PlaceRequestArgument placeRequestArgumenent) {
		int filterCategory = placeRequestArgumenent.getFilterCategory();
		
		if(filterCategory > 0) {
			builder.withParameter("category", Integer.toString(filterCategory));
		}
	}

	private ApiRequestBuilder createDefaultApiRequestBuilder(
			PlacesApiRequest placesApiRequest,
			PlaceRequestArgument placeRequestArgumenent) {
		return createMinimalApiRequestBuilder(placesApiRequest)
			.withPath("/places/byradius")
			.withParameter("radius", Double.toString(placeRequestArgumenent.getRadius()))
			.withParameter("latitude", Double.toString(placeRequestArgumenent.getLatitude()))
			.withParameter("longitude", Double.toString(placeRequestArgumenent.getLongitude()));
	}

	private ApiRequestBuilder createMinimalApiRequestBuilder(
			PlacesApiRequest placesApiRequest) {
		return apiRequestBuilder
			.withHost(placesApiRequest.getHost())
			.withLicenseInfo(placesApiRequest.getLicenseLogin(), placesApiRequest.getLicenseKey());
	}
}
