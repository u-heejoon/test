package com.sso.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

public class P6spySqlFormatter implements MessageFormattingStrategy {
    private static final String CREATE = "create";
    private static final String ALTER = "alter";
    private static final String COMMENT = "comment";

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if (sql.trim().isEmpty()) {
            return "";
        }

        return sqlFormat(sql, category) + getMessage(connectionId, elapsed);
    }

    private String getMessage(final int connectionId, final long elapsed) {
        return System.lineSeparator() +
               "----------------------------------------------------------------------------------------------------" +
               System.lineSeparator() +
               "\t" + String.format("[Connection ID] \t%s", connectionId) +
               System.lineSeparator() +
               "\t" + String.format("[Execution Time] \t%s ms", elapsed) +
               System.lineSeparator() +
               "----------------------------------------------------------------------------------------------------";
    }

    private String sqlFormat(final String sql, final String category) {
        if (isStatementDdl(sql, category)) {
            return FormatStyle.DDL
              .getFormatter()
              .format(sql)
              .toUpperCase(Locale.ROOT)
              .replace("+0900", "");
        }

        return FormatStyle.BASIC
          .getFormatter()
          .format(sql)
          .replace("+0900", "");
    }

    private boolean isStatementDdl(final String sql, final String category) {
        return isStatement(category) && isDdl(sql);
    }

    private boolean isStatement(final String category) {
        return Category.STATEMENT.getName().equals(category);
    }

    private boolean isDdl(final String sql) {
        final String lowerSql = sql.trim().toLowerCase(Locale.ROOT);
        return lowerSql.startsWith(CREATE) || lowerSql.startsWith(ALTER) || lowerSql.startsWith(COMMENT);
    }

}