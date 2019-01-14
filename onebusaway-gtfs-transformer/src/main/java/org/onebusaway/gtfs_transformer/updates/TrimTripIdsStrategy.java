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
package org.onebusaway.gtfs_transformer.updates;

import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.gtfs.model.Trip;
import org.onebusaway.gtfs.services.GtfsMutableRelationalDao;
import org.onebusaway.gtfs_transformer.services.GtfsTransformStrategy;
import org.onebusaway.gtfs_transformer.services.TransformContext;

public class TrimTripIdsStrategy implements GtfsTransformStrategy {

	private String length;

	
	@Override
	public void run(TransformContext context, GtfsMutableRelationalDao dao) {

		for (Trip trip : dao.getAllTrips()) {

			if(length!=null)
			{
				int len=new Integer(length);
				AgencyAndId newId = new AgencyAndId(trip.getId().getAgencyId(),
						trip.getId().getId().substring(0, len));
				trip.setId(newId);
			}

		}
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}
	

}
