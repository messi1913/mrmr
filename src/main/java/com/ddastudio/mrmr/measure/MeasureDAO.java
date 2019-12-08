package com.ddastudio.mrmr.measure;

import com.ddastudio.mrmr.measure.model.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@Repository
@RequiredArgsConstructor
public class MeasureDAO {

    private final JPAQueryFactory query;

    private static final QBmi BMI = QBmi.bmi;
    private static final QHeight HEIGHT = QHeight.height;
    private static final QWeight WEIGHT = QWeight.weight;
    private static final QWeightByHeight WEIGHT_BY_HEIGHT = QWeightByHeight.weightByHeight;
    private static final QHeadCircumference HEAD_CIRCUMFERENCE = QHeadCircumference.headCircumference;

    public List<Bmi> getBmi(MeasureParams params) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if(!Objects.isNull(params.getGender())) {
            whereBuilder.and(BMI.id.gender.eq(params.getGender()));
        }
        if(!Objects.isNull(params.getMonth())) {
            whereBuilder.and(BMI.id.month.eq(params.getMonth()));
        }
        if(!Objects.isNull(params.getAge())) {
            whereBuilder.and(BMI.id.age.eq(params.getAge()));
        }

        return query.selectFrom(BMI)
                .where(whereBuilder)
                .orderBy(BMI.id.gender.asc(), BMI.id.age.asc(), BMI.id.month.asc())
                .fetch();
    }

    public List<Height> getHeight(MeasureParams params) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if(!Objects.isNull(params.getGender())) {
            whereBuilder.and(HEIGHT.id.gender.eq(params.getGender()));
        }
        if(!Objects.isNull(params.getMonth())) {
            whereBuilder.and(HEIGHT.id.month.eq(params.getMonth()));
        }
        if(!Objects.isNull(params.getAge())) {
            whereBuilder.and(HEIGHT.id.age.eq(params.getAge()));
        }
        return query.selectFrom(HEIGHT)
                .where(whereBuilder)
                .orderBy(HEIGHT.id.gender.asc(), HEIGHT.id.age.asc(), HEIGHT.id.month.asc())
                .fetch();
    }

    public List<Weight> getWeight(MeasureParams params) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if(!Objects.isNull(params.getGender())) {
            whereBuilder.and(WEIGHT.id.gender.eq(params.getGender()));
        }
        if(!Objects.isNull(params.getMonth())) {
            whereBuilder.and(WEIGHT.id.month.eq(params.getMonth()));
        }
        if(!Objects.isNull(params.getAge())) {
            whereBuilder.and(WEIGHT.id.age.eq(params.getAge()));
        }
        return query.selectFrom(WEIGHT)
                .where(whereBuilder)
                .orderBy(WEIGHT.id.gender.asc(), WEIGHT.id.age.asc(), WEIGHT.id.month.asc())
                .fetch();
    }

    public List<HeadCircumference> getHeadCircumference(MeasureParams params) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if(!Objects.isNull(params.getGender())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.gender.eq(params.getGender()));
        }
        if(!Objects.isNull(params.getMonth())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.month.eq(params.getMonth()));
        }
        if(!Objects.isNull(params.getAge())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.age.eq(params.getAge()));
        }
        return query.selectFrom(HEAD_CIRCUMFERENCE)
                .where(whereBuilder)
                .orderBy(HEAD_CIRCUMFERENCE.id.gender.asc(), HEAD_CIRCUMFERENCE.id.age.asc(), HEAD_CIRCUMFERENCE.id.month.asc())
                .fetch();
    }

    public List<WeightByHeight> getWeightByHeight(MeasureParams params) {
        return query.selectFrom(WEIGHT_BY_HEIGHT)
                .where(WEIGHT_BY_HEIGHT.id.gender.eq(params.getGender())
                    .and(WEIGHT_BY_HEIGHT.id.height.eq(params.getHeight())))
                .orderBy(WEIGHT_BY_HEIGHT.id.gender.asc(), WEIGHT_BY_HEIGHT.id.fromMonth.asc())
                .fetch();
    }

}
