package br.com.maplink.webservices.places.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.com.maplink.webservices.places.client.builder.ApiRequestBuilder;
import br.com.maplink.webservices.places.client.converter.CategoryConverter;
import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;
import br.com.maplink.webservices.places.client.resource.Categories;
import br.com.maplink.webservices.places.client.service.ResourceRequestRetriever;

public class CategorySearcherImpl implements CategorySearcher {

	private final ApiRequestBuilder apiRequestBuilder;
	private final ResourceRequestRetriever resourceRetriever;
	private final CategoryConverter categoryConverter;

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
	throws InvalidKeyException, NoSuchAlgorithmException, MalformedURLException, IOException, PlacesApiClientRequestException {
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
