package com.researchspace.protocolsio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.time.DurationFormatUtils;

public class PIOStepComponentType {

    @JsonIgnore
    public String getFormattedQuantityString(double amount, String unit, PIOStepComponentType type) {
        StringBuilder result = new StringBuilder();

        if(!unit.isEmpty()) {
            result.append(amount).append(" ").append(unit);
        } else {
            if(type instanceof PIOAmountComponentType) {
                result.append(amount);
            } else if(type instanceof PIOConcentrationComponentType) {
                result.append(amount + " mg/ml"); // This unit appears as null via the API, see protocol: https://www.protocols.io/view/recombinant-protein-expression-and-purification-of-bzusp6we id: 54898
            } else if(type instanceof PIOTemperatureComponentType) {
                result.append("Room Temperature");
            }
        }
        return result.toString();
    }

    /**
     * This method provides a string representing a shaker object retrieved from ProtocolsIO API
     * @param shaker the shaker object
     * @return the string representation of the shaker component e.g: 50 rpm, 37°C, 20 minutes
     */
    @JsonIgnore
    public String getShakerString(PIOShakerComponentType shaker) {
        StringBuilder result = new StringBuilder();

        // PIO API has several unit numbers that correspond to various units
        if(shaker.getUnit() == 33) {
            result.append(shaker.getShaker()).append(" rpm");
        } else if(shaker.getUnit() == 34) {
            result.append(shaker.getShaker()).append(" x g");
        }

        if(shaker.getTemperatureUnit() == 10) {
            // temperature unit id 10 = °C
            result.append(", ").append(shaker.getTemperature()).append("°C");
        }

        if(shaker.getDuration() != 0) {
            result.append(", ").append(getDurationString(shaker.getDuration()));
        }


        return result.toString();
    }

    /**
     * This method provides a string representing a centrifuge object retrieved from ProtocolsIO API
     * @param centrifugeType the centrifuge object
     * @return the string representation of the centrifuge component e.g: 50 rpm, 37°C, 20 minutes
     */
    @JsonIgnore
    public String getCentrifugeString(PIOCentrifugeComponentType centrifugeType) {
        StringBuilder result = new StringBuilder();

        // PIO API has several unit numbers that correspond to various units
        if(centrifugeType.getUnit() == 33) {
            result.append(centrifugeType.getCentrifuge()).append(" rpm");
        } else if(centrifugeType.getUnit() == 34) {
            result.append(centrifugeType.getCentrifuge()).append(" x g");
        }

        if(centrifugeType.getTemperatureUnit() == 10) {
            // temperature unit id 10 = °C
            result.append(", ").append(centrifugeType.getTemperature()).append("°C");
        }

        if(centrifugeType.getDuration() != 0) {
            result.append(", ").append(getDurationString(centrifugeType.getDuration()));
        }


        return result.toString();
    }

    /**
     * Gets the duration in words, e.g. '5 hours 30 minutes'
     *
     * @return
     */
    @JsonIgnore
    public String getDurationString(int duration) {
        if (duration != 0) {
            return DurationFormatUtils.formatDurationWords(duration * 1000L, true, true);
        } else {
            return "";
        }
    }

}
