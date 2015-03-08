# onebusaway-gtfs-modules
These are changes to the onebusaway-gtfs-modules to support new fields as in the GTFS fares extension proposal, 
along with a few home grown ones.

The changes are to support fares by product, service and with an optional effective date range for each fare_attribute.

The effective date range is meant to work in the the fare_attribute with the smallest range in date covering the current time/fare
is the one in effect.

Along with these changes I have introduced an optional discount field to be used along side value. I would use to price
maintain a basefare but show that the customer getting a discount by filling in this optional field.

I have added the field for distance categories but have yet to use these.

/* TODO Test cases need to be modified to reflect these new fields */
