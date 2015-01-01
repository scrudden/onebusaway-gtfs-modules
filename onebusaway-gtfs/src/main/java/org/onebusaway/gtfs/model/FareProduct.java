/**
 * Copyright (C) 2014 Sean Og Crudden <og.crudden@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.gtfs.model;

import org.onebusaway.csv_entities.schema.annotations.CsvField;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;
import org.onebusaway.gtfs.serialization.mappings.DefaultAgencyIdFieldMappingFactory;

@CsvFields(filename = "fare_products.txt",  prefix = "product_" , required = false)
public class FareProduct extends IdentityBean<AgencyAndId> {
		
	private static final long serialVersionUID = 1L;

	public FareProduct(AgencyAndId id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public FareProduct(FareProduct fp)
	{
		this.id=fp.getId();
		this.name=fp.getName();
	}

	public FareProduct() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@CsvField(mapping = DefaultAgencyIdFieldMappingFactory.class)
	private AgencyAndId id;

	@CsvField( optional = false)
	private String name;


	public AgencyAndId getId() {
		return id;
	}

	public void setId(AgencyAndId id) {
		this.id = id;
	}	
}
