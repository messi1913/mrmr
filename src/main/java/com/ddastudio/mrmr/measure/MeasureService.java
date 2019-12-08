package com.ddastudio.mrmr.measure;

import com.ddastudio.mrmr.measure.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.ddastudio.mrmr.measure.MeasureConstants.*;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MeasureService {

    private final MeasureDAO measureDAO;

    public Object getInfoByCondition(MeasureParams params) throws Exception {
        String type = params.getType();
        switch (type) {
            case BMI :
                return this.getBmiByCondition(params);
            case HEIGHT :
                return this.getHeightByCondition(params);
            case WEIGHT :
                return this.getWeightByCondition(params);
            case HEAD :
                return this.getHeadCircumferenceByCondition(params);
            case WEIGHT_BY_HEIGHT :
                return this.getWeightByHeight(params);
        }
        return null;
    }

    public List<Bmi> getBmiByCondition(MeasureParams params) throws Exception {
        if(Objects.isNull(params.getGender())){
            throw new Exception("Exception 만들어야 됨.");
        }

        return measureDAO.getBmi(params);
    }

    public List<Height> getHeightByCondition(MeasureParams params) throws Exception {
        if(Objects.isNull(params.getGender())){
            throw new Exception("Exception 만들어야 됨.");
        }

        return measureDAO.getHeight(params);
    }

    public List<Weight> getWeightByCondition(MeasureParams params) throws Exception {
        if(Objects.isNull(params.getGender())){
            throw new Exception("Exception 만들어야 됨.");
        }

        return measureDAO.getWeight(params);
    }

    public List<HeadCircumference> getHeadCircumferenceByCondition(MeasureParams params) throws Exception {
        if(Objects.isNull(params.getGender())){
            throw new Exception("Exception 만들어야 됨.");
        }

        return measureDAO.getHeadCircumference(params);
    }

    public List<WeightByHeight> getWeightByHeight(MeasureParams params) throws Exception {
        if(Objects.isNull(params.getGender()) || Objects.isNull(params.getHeight())){
            throw new Exception("Exception 만들어야 됨.");
        }
        return measureDAO.getWeightByHeight(params);
    }



}
