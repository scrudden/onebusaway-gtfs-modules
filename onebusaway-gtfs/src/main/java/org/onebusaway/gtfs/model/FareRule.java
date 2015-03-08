/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
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
import org.onebusaway.gtfs.serialization.mappings.EntityFieldMappingFactory;

@CsvFields(filename = "fare_rules.txt", required = false)
public final class FareRule extends IdentityBean<Integer> {

  @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((containsId == null) ? 0 : containsId.hashCode());
		result = prime * result
				+ ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((fareId == null) ? 0 : fareId.hashCode());
		result = prime * result
				+ ((originId == null) ? 0 : originId.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result
				+ ((serviceId == null) ? 0 : serviceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FareRule other = (FareRule) obj;
		if (containsId == null) {
			if (other.containsId != null)
				return false;
		} else if (!containsId.equals(other.containsId))
			return false;
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		if (fareId == null) {
			if (other.fareId != null)
				return false;
		} else if (!fareId.equals(other.fareId))
			return false;
		if (originId == null) {
			if (other.originId != null)
				return false;
		} else if (!originId.equals(other.originId))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}

private static final long serialVersionUID = 1L;

  @CsvField(ignore = true)
  private int id;

  @CsvField(name = "fare_id", optional = false, mapping = DefaultAgencyIdFieldMappingFactory.class)
  private AgencyAndId fareId;

  @CsvField(name = "route_id", optional = true, mapping = EntityFieldMappingFactory.class)
  private Route route;

  @CsvField(optional = true)
  private String originId;

  @CsvField(optional = true)
  private String destinationId;

  @CsvField(optional = true)
  private String containsId;
    
  
  @CsvField(optional = true, mapping = DefaultAgencyIdFieldMappingFactory.class)
  private AgencyAndId serviceId;
  

  
  
public AgencyAndId getServiceId() {
	return serviceId;
}

public void setServiceId(AgencyAndId serviceId) {
	this.serviceId = serviceId;
}

public FareRule() {

  }

  public FareRule(FareRule fr) {
    this.id = fr.id;
    this.fareId = fr.fareId;
    this.route = fr.route;
    this.originId = fr.originId;
    this.destinationId = fr.destinationId;
    this.containsId = fr.containsId;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

 

  public AgencyAndId getFareId() {
	return fareId;
}

public void setFareId(AgencyAndId fareId) {
	this.fareId = fareId;
}

public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public String getOriginId() {
    return originId;
  }

  public void setOriginId(String originId) {
    this.originId = originId;
  }

  public String getDestinationId() {
    return destinationId;
  }

  public void setDestinationId(String destinationId) {
    this.destinationId = destinationId;
  }

  public String getContainsId() {
    return containsId;
  }

  public void setContainsId(String containsId) {
    this.containsId = containsId;
  }

  public String toString() {
    return "<FareRule " + getId() + ">";
  }
}
