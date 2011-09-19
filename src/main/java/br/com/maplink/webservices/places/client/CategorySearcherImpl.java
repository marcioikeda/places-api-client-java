package br.com.maplink.webservices.places.client;

import br.com.maplink.webservices.places.client.builder.*;
import br.com.maplink.webservices.places.client.converter.CategoryConverter;
import br.com.maplink.webservices.places.client.converter.CategoryConverterImpl;
import br.com.maplink.webservices.places.client.converter.DateConverterImpl;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;
import br.com.maplink.webservices.places.client.helper.Base64EncoderImpl;
import br.com.maplink.webservices.places.client.helper.ClockImpl;
import br.com.maplink.webservices.places.client.helper.HexHmacSha1GeneratorImpl;
import br.com.maplink.webservices.places.client.resource.Categories;
import br.com.maplink.webservices.places.client.service.HttpResponseRetrieverImpl;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetrieverImpl;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import br.com.tealdi.httpclient.HttpClient;
import br.com.tealdi.httpclient.builder.RequestBuilder;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CategorySearcherImpl implements CategorySearcher {

	private final ApiRequestBuilder apiRequestBuilder;
	private final ResourceRequestRetriever resourceRetriever;
	private final CategoryConverter categoryConverter;

	public CategorySearcherImpl() {
		this(
			new ApiRequestBuilderImpl(),
			new ResourceRequestRetrieverImpl(
					new RequestAuthorizationBuilderImpl(
							new AuthorizationRfc1132DateGeneratorImpl(new ClockImpl(), new DateConverterImpl()),
							new UriBuilderImpl(new QueryStringBuilderImpl()),
							new AuthorizationHeaderBuilderImpl(new HexHmacSha1GeneratorImpl(), new Base64EncoderImpl())),
					new HttpResponseRetrieverImpl(new RequestBuilder(), new HttpClient()),
					new XmlSerializerWrapperImpl()),
			new CategoryConverterImpl());
	}
	
	public CategorySearcherImpl(
			ApiRequestBuilder apiRequestBuilder,
			ResourceRequestRetriever resourceRetriever,
			CategoryConverter categoryConverter) {
				this.apiRequestBuilder = apiRequestBuilder;
				this.resourceRetriever = resourceRetriever;
				this.categoryConverter = categoryConverter;
	
	}

	@Override
	public List<Category> all(PlacesApiRequest placeApiRequest) 
	throws InvalidKeyException, NoSuchAlgorithmException, IOException, PlacesApiClientRequestException {
		ApiRequest request = 
			apiRequestBuilder
				.withHost(placeApiRequest.getHost())
				.withPath("/categories")
				.withLicenseInfo(placeApiRequest.getLicenseLogin(), placeApiRequest.getLicenseKey())
				.build();
		
		Categories resourceCategoriesRetrieved = resourceRetriever.retrieve(Categories.class, request);
		
		return categoryConverter.toEntity(resourceCategoriesRetrieved);
	}
}
