import pandas as pd
import pymysql
from sklearn.ensemble import RandomForestRegressor
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDRegressor
import xgboost as xgb
import lightgbm as lgb
import numpy as np
import datetime
import os
def processdata(data):
    code=data['股票代码'].values[0].replace("'","")
    xr=data[['最高价','最低价','开盘价','成交金额']].values
    yr1=data['收盘价'].values
    yr2=data['前收盘'].values
    x1=np.arange(len(data)).reshape(-1,1)
    y1=data.values[:,4]
    y2=data.values[:,5]
    y3=data.values[:,6]
    y4=data.values[:,12]
    rf1=RandomForestRegressor(n_estimators=50)
    rf2=RandomForestRegressor(n_estimators=50)
    rf3=RandomForestRegressor(n_estimators=50)
    rf4=RandomForestRegressor(n_estimators=50)
    rf1.fit(x1,y1)
    rf2.fit(x1,y2)
    rf3.fit(x1,y3)
    rf4.fit(x1,y4)
    tail=x1[-1]+1
    period=np.arange(tail,tail+7).reshape(-1,1)
    _y1=rf1.predict(period)
    _y2=rf2.predict(period)
    _y3=rf3.predict(period)
    _y4=rf4.predict(period)
    xf=np.c_[_y1,_y2,_y3,_y4]
    xgb1=xgb.XGBRegressor()
    xgb2=xgb.XGBRegressor()
    xgb1.fit(xr,yr1)
    xgb2.fit(xr,yr2)
    yf1=xgb1.predict(xf)
    yf2=xgb2.predict(xf)
    return yf1,yf2,code
def insert_to(yf1,yf2,code):
    nowdate=datetime.datetime.now()
    for i in range(len(yf1)):
        curdate=nowdate+datetime.timedelta(days=i)
        if i==0:
            sql="insert into FUTURE_DATA(date,code,close,pre_close) values('"+curdate.strftime('%Y-%m-%d')+"','"+code+"',"+str(yf1[i])+","+str(yf2[i])+")"
        else:
            sql+=",('"+curdate.strftime('%Y-%m-%d')+"','"+code+"',"+str(yf1[i])+","+str(yf2[i])+")"
    try:
        print(sql)
        cursor.execute(sql)
        db.commit()
    except:
        db.rollback()
db=pymysql.connect('localhost','root','mysql','stocks')
cursor=db.cursor()
path='/home/fei/ML/datasets/stocks/'
names=os.listdir(path)
for name in names:
    filename=path+name
    print(filename)
    data=pd.read_csv(filename,encoding='gbk')
    yf1,yf2,code=processdata(data)
    insert_to(yf1,yf2,code)
db.close()