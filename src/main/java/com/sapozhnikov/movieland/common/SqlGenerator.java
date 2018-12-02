package com.sapozhnikov.movieland.common;

public class SqlGenerator {
    private static final String SORTED_SQL_TEMPLATE = "select * from (%s) t order by %s %s";

    public static String getSortedSql(String sql, MovieRequestParam movieRequestParam){
        return String.format(SORTED_SQL_TEMPLATE, sql, movieRequestParam.getSortField(), movieRequestParam.getSortDirection());
    }
}
