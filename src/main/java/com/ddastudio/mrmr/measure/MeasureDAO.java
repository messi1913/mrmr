package com.ddastudio.mrmr.measure;

import com.ddastudio.mrmr.measure.model.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Bmi> getBmi(MeasureParams params, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if (!Objects.isNull(params.getGender())) {
            whereBuilder.and(BMI.id.gender.eq(params.getGender()));
        }
        if (!Objects.isNull(params.getMonth())) {
            whereBuilder.and(BMI.id.month.eq(params.getMonth()));
        }
        if (!Objects.isNull(params.getAge())) {
            whereBuilder.and(BMI.id.age.eq(params.getAge()));
        }

        QueryResults<Bmi> results = query.selectFrom(BMI)
                .where(whereBuilder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(BMI.id.gender.asc(), BMI.id.age.asc(), BMI.id.month.asc())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());

    }

    public Page<Height> getHeight(MeasureParams params, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if (!Objects.isNull(params.getGender())) {
            whereBuilder.and(HEIGHT.id.gender.eq(params.getGender()));
        }
        if (!Objects.isNull(params.getMonth())) {
            whereBuilder.and(HEIGHT.id.month.eq(params.getMonth()));
        }
        if (!Objects.isNull(params.getAge())) {
            whereBuilder.and(HEIGHT.id.age.eq(params.getAge()));
        }
        QueryResults<Height> results = query.selectFrom(HEIGHT)
                .where(whereBuilder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(HEIGHT.id.gender.asc(), HEIGHT.id.age.asc(), HEIGHT.id.month.asc())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<Weight> getWeight(MeasureParams params, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if (!Objects.isNull(params.getGender())) {
            whereBuilder.and(WEIGHT.id.gender.eq(params.getGender()));
        }
        if (!Objects.isNull(params.getMonth())) {
            whereBuilder.and(WEIGHT.id.month.eq(params.getMonth()));
        }
        if (!Objects.isNull(params.getAge())) {
            whereBuilder.and(WEIGHT.id.age.eq(params.getAge()));
        }
        QueryResults<Weight> results = query.selectFrom(WEIGHT)
                .where(whereBuilder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(WEIGHT.id.gender.asc(), WEIGHT.id.age.asc(), WEIGHT.id.month.asc())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<HeadCircumference> getHeadCircumference(MeasureParams params, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if (!Objects.isNull(params.getGender())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.gender.eq(params.getGender()));
        }
        if (!Objects.isNull(params.getMonth())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.month.eq(params.getMonth()));
        }
        if (!Objects.isNull(params.getAge())) {
            whereBuilder.and(HEAD_CIRCUMFERENCE.id.age.eq(params.getAge()));
        }
        QueryResults<HeadCircumference> results = query.selectFrom(HEAD_CIRCUMFERENCE)
                .where(whereBuilder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(HEAD_CIRCUMFERENCE.id.gender.asc(), HEAD_CIRCUMFERENCE.id.age.asc(), HEAD_CIRCUMFERENCE.id.month.asc())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<WeightByHeight> getWeightByHeight(MeasureParams params, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();
        if (!Objects.isNull(params.getGender())) {
            whereBuilder.and(WEIGHT_BY_HEIGHT.id.gender.eq(params.getGender()));
        }
        if (!Objects.isNull(params.getMonth())) {
            whereBuilder.and(WEIGHT_BY_HEIGHT.id.height.eq(params.getHeight()));
        }
        QueryResults<WeightByHeight> results = query.selectFrom(WEIGHT_BY_HEIGHT)
                .where(whereBuilder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(WEIGHT_BY_HEIGHT.id.gender.asc(), WEIGHT_BY_HEIGHT.id.fromMonth.asc())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

}
