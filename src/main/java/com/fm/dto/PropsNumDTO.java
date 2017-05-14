package com.fm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fm.consts.FlowerPropsDict;

/**
 * Created by aiyi on 2017/5/13.
 */
public class PropsNumDTO {


    private FreeProps freeProps;

    private ChargeProps chargeProps;


    public static FreeProps createFreeProps(Integer irrigation, Integer weeding, Integer insecticide, Integer illumination) {
        return new FreeProps(irrigation, weeding, insecticide, illumination);
    }

    public static ChargeProps createChargeProps(Integer fertilization) {
        return new ChargeProps(fertilization);
    }


    public FreeProps getFreeProps() {
        return freeProps;
    }

    public void setFreeProps(FreeProps freeProps) {
        this.freeProps = freeProps;
    }

    public ChargeProps getChargeProps() {
        return chargeProps;
    }

    public void setChargeProps(ChargeProps chargeProps) {
        this.chargeProps = chargeProps;
    }


    public boolean canUse(Long id) {
        if (id == FlowerPropsDict.IRRIGATION) {
            return freeProps.getIrrigation() > 0;
        } else if (id == FlowerPropsDict.WEEDING) {
            return freeProps.getWeeding() > 0;
        } else if (id == FlowerPropsDict.INSECTICIDE) {
            return freeProps.getInsecticide() > 0;
        } else if (id == FlowerPropsDict.ILLUMINATION) {
            return freeProps.getIllumination() > 0;
        } else {
            return chargeProps.fertilization > 0;
        }
    }


    static class FreeProps {
        @JsonProperty("灌溉")
        private Integer irrigation;

        @JsonProperty("除草")
        private Integer weeding;

        @JsonProperty("杀虫")
        private Integer insecticide;

        @JsonProperty("光照")
        private Integer illumination;

        public FreeProps(Integer irrigation, Integer weeding, Integer insecticide, Integer illumination) {
            this.irrigation = irrigation;
            this.weeding = weeding;
            this.insecticide = insecticide;
            this.illumination = illumination;
        }

        public Integer getIrrigation() {
            return irrigation;
        }

        public void setIrrigation(Integer irrigation) {
            this.irrigation = irrigation;
        }

        public Integer getWeeding() {
            return weeding;
        }

        public void setWeeding(Integer weeding) {
            this.weeding = weeding;
        }

        public Integer getInsecticide() {
            return insecticide;
        }

        public void setInsecticide(Integer insecticide) {
            this.insecticide = insecticide;
        }

        public Integer getIllumination() {
            return illumination;
        }

        public void setIllumination(Integer illumination) {
            this.illumination = illumination;
        }
    }

    static class ChargeProps {

        @JsonProperty("施肥")
        private Integer fertilization;

        public ChargeProps(Integer fertilization) {
            this.fertilization = fertilization;
        }

        public Integer getFertilization() {
            return fertilization;
        }

        public void setFertilization(Integer fertilization) {
            this.fertilization = fertilization;
        }
    }

}
