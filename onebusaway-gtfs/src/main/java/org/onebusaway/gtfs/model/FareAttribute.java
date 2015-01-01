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
import org.onebusaway.gtfs.model.calendar.ServiceDate;
import org.onebusaway.gtfs.serialization.mappings.DefaultAgencyIdFieldMappingFactory;
import org.onebusaway.gtfs.serialization.mappings.EntityFieldMappingFactory;
import org.onebusaway.gtfs.serialization.mappings.ServiceDateFieldMappingFactory;
import org.onebusaway.gtfs.serialization.mappings.StopTimeFieldMappingFactory;

@CsvFields(filename = "fare_attributes.txt", required = false)
public final class FareAttribute extends IdentityBean<AgencyAndId> {

	private static final long serialVersionUID = 1L;

	private static final int MISSING_VALUE = -999;
	
	@CsvField(name = "fare_id", mapping = DefaultAgencyIdFieldMappingFactory.class)
	private AgencyAndId id;

	@CsvField(name = "product_id",  mapping = EntityFieldMappingFactory.class, optional=true)
	private FareProduct product;

	public FareProduct getProduct() {
		return product;
	}

	public void setProduct(FareProduct product) {
		this.product = product;
	}
		
	@CsvField(name = "fare_rule_id", mapping = DefaultAgencyIdFieldMappingFactory.class)
	private AgencyAndId fareRuleId;
	
	
	public AgencyAndId getFareRuleId() {
		return fareRuleId;
	}

	public void setFareRuleId(AgencyAndId fareRuleId) {
		this.fareRuleId = fareRuleId;
	}

	private float price;

	private String currencyType;

	private int paymentMethod;

	@CsvField(optional = true)
	private int transfers = MISSING_VALUE;

	@CsvField(optional = true)
	private int transferDuration = MISSING_VALUE;

	/**
	 * This is a proposed extension to the GTFS spec
	 */
	@CsvField(optional = true)
	private int journeyDuration = MISSING_VALUE;
	

	@CsvField(optional=true, mapping = ServiceDateFieldMappingFactory.class)
	private ServiceDate fareStartDate;
	
	@CsvField(optional = true, mapping = StopTimeFieldMappingFactory.class)
	private int fareStartTime = MISSING_VALUE;

	
	@CsvField(optional = true, mapping = ServiceDateFieldMappingFactory.class)
	private ServiceDate fareEndDate;
	
	@CsvField(optional = true, mapping = StopTimeFieldMappingFactory.class)
	private int fareEndTime = MISSING_VALUE;
	
	public FareAttribute() {

	}

	public FareAttribute(FareAttribute fa) {
		this.id = fa.id;
		this.price = fa.price;
		this.currencyType = fa.currencyType;
		this.paymentMethod = fa.paymentMethod;
		this.transfers = fa.transfers;
		this.transferDuration = fa.transferDuration;
		this.journeyDuration = fa.journeyDuration;
		this.fareStartDate=fa.fareStartDate;
		this.fareStartTime=fa.fareStartTime;
		this.fareEndDate=fa.fareEndDate;
		this.fareEndTime=fa.fareEndTime;
	}

	public ServiceDate getFareEndDate() {
		return fareEndDate;
	}

	public void setFareEndDate(ServiceDate fareEndDate) {
		this.fareEndDate = fareEndDate;
	}

	public int getFareEndTime() {
		return fareEndTime;
	}

	public void setFareEndTime(int fareEndTime) {
		this.fareEndTime = fareEndTime;
	}

	public ServiceDate getFareStartDate() {
		return fareStartDate;
	}

	public void setFareStartDate(ServiceDate fareStartDate) {
		this.fareStartDate = fareStartDate;
	}

	public int getFareStartTime() {
		return fareStartTime;
	}

	public void setFareStartTime(int fareStartTime) {
		this.fareStartTime = fareStartTime;
	}

	@Override
	public AgencyAndId getId() {
		return id;
	}

	@Override
	public void setId(AgencyAndId id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isTransfersSet() {
		return transfers != MISSING_VALUE;
	}

	public int getTransfers() {
		return transfers;
	}

	public void setTransfers(int transfers) {
		this.transfers = transfers;
	}

	public void clearTransfers() {
		this.transfers = MISSING_VALUE;
	}

	public boolean isTransferDurationSet() {
		return transferDuration != MISSING_VALUE;
	}

	public int getTransferDuration() {
		return transferDuration;
	}

	public void setTransferDuration(int transferDuration) {
		this.transferDuration = transferDuration;
	}

	public void clearTransferDuration() {
		this.transferDuration = MISSING_VALUE;
	}

	public boolean isJourneyDurationSet() {
		return journeyDuration != MISSING_VALUE;
	}

	public int getJourneyDuration() {
		return journeyDuration;
	}

	public void setJourneyDuration(int journeyDuration) {
		this.journeyDuration = journeyDuration;
	}

	public void clearJourneyDuration() {
		this.journeyDuration = MISSING_VALUE;
	}

	public String toString() {
		return "<FareAttribute " + getId() + ">";
	}
}
