#date code(股票代码) name close(收盘价) top bottom open(开盘价) pre_close(前收盘) change_num(涨跌额) chage_rate(涨跌幅) turnover_rate(换手率) volume(成交量) amount(成交额) value(市值) equity(流通市值)
DROP TABLE IF EXISTS STOCK_LIST;
DROP TABLE IF EXISTS HISTORY_DATA;
DROP TABLE IF EXISTS FUTURE_DATA;
ALTER DATABASE stocks
CHARSET 'gbk';
#股票列表
CREATE TABLE STOCK_LIST(
  CODE VARCHAR(8),
  NAME VARCHAR(30)
);
#历史数据表
CREATE TABLE HISTORY_DATA(
  DATE          VARCHAR(10),
  CODE          VARCHAR(8),
  CLOSE         DECIMAL(6,2),
  TOP           DECIMAL(6,2),
  BOTTOM        DECIMAL(6,2),
  OPEN          DECIMAL(6,2),
  PRE_CLOSE     DECIMAL(6,2),
  CHANGE_NUM    DECIMAL(4,2),
  CHANGE_RATE   DECIMAL(6,4),
  TURNOVER_RATE DECIMAL(6,4),
  VOLUME        INT,
  AMOUNT        DECIMAL(12,2),
  VALUE         BIGINT,
  EQUITY        BIGINT
);
#预测数据表
CREATE TABLE FUTURE_DATA(
  DATE VARCHAR(10),
  CODE VARCHAR(8),
  CLOSE DECIMAL(6,2)
)