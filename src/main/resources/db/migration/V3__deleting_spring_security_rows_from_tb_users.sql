--remove as colunas relativas ao Spring Security na tabela TB_USERS. Se houver necessidade, serão incluídas novamente.

ALTER TABLE TB_USERS
    DROP (
          ACCOUNT_NON_EXPIRED,
          ACCOUNT_NON_LOCKED,
          CREDENTIALS_NON_EXPIRED,
          ENABLED,
          "ROLE"
        );
