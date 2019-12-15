package com.ddastudio.mrmr.measure.service;

import com.ddastudio.mrmr.measure.MeasureDAO;
import com.ddastudio.mrmr.measure.MeasureParams;
import com.ddastudio.mrmr.measure.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
    private final ModelMapper modelMapper;

    public Page<MeasureDTO> getInfoByCondition(MeasureParams params, Pageable pageable) {
        String type = params.getType();
        switch (type) {
            case BMI:
                return this.getBmiByCondition(params, pageable).map(source -> modelMapper.map(source, MeasureDTO.class));
            case HEIGHT:
                return this.getHeightByCondition(params, pageable).map(source -> modelMapper.map(source, MeasureDTO.class));
            case WEIGHT:
                return this.getWeightByCondition(params, pageable).map(source -> modelMapper.map(source, MeasureDTO.class));
            case HEAD:
                return this.getHeadCircumferenceByCondition(params, pageable).map(source -> modelMapper.map(source, MeasureDTO.class));
            case WEIGHT_BY_HEIGHT :
                return this.getWeightByHeight(params, pageable).map(source -> modelMapper.map(source, MeasureDTO.class));
        }
        return null;
    }

    public Page<Bmi> getBmiByCondition(MeasureParams params, Pageable pageable) {
        return measureDAO.getBmi(params, pageable);
    }

    public Page<Height> getHeightByCondition(MeasureParams params, Pageable pageable) {
        return measureDAO.getHeight(params, pageable);
    }

    public Page<Weight> getWeightByCondition(MeasureParams params, Pageable pageable) {
        return measureDAO.getWeight(params, pageable);
    }

    public Page<HeadCircumference> getHeadCircumferenceByCondition(MeasureParams params, Pageable pageable) {
        return measureDAO.getHeadCircumference(params, pageable);
    }

    public Page<WeightByHeight> getWeightByHeight(MeasureParams params, Pageable pageable) {
        return measureDAO.getWeightByHeight(params, pageable);
    }


}
