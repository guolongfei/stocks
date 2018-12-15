import urllib
import re
import os
import pandas as pd
#获取股票列表
html=urllib.urlopen('http://quote.eastmoney.com/stocklist.html').read()
p=re.compile('<a target="_blank" href="http://quote.eastmoney.com/..(\d*).html')
codes=p.findall(html)
code=[]
for item in codes:
    if item[0]=='6':
        code.append(item)
#下载股票数据到本地
path='/home/longfei/PY3/datasets/stocks/'
if not os.path.exists(path):
    os.mkdir(path)
prefix='http://quotes.money.163.com/service/chddata.html?code=0'
suffix='&end=20181215&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP'
for item in code:
    url=prefix+item+suffix
    s=urllib.urlopen(url).read()
    curl=path+item+'.csv'
    if not os.path.exists(curl):
        os.mknod(curl)
    with open(curl,'w+') as f:
        f.write(s)
#将股票信息存到数据库
db=pymysql.connect('localhost','root','root','stocks')
cursor=db.cursor()
names=os.listdir(path)
for name in names:
    filename=path+name
    print(filename)
    df=pd.read_csv(filename,encoding='gbk')
    data=df.values;
    for i in range(len(data)):
        row=list(data[i])
        if i==0:
            sql="insert into STOCK_LIST(code,name) values('"+row[1].replace("'","")+"','"+row[2]+"');"
            try:
                cursor.execute(sql)
                db.commit()
            except:
                db.rollback()
        sql="insert into HISTORY_DATA(date,code,close,top,bottom,open,pre_close,change_num,change_rate,turnover_rate,volume,amount,value,equity) values"\
        +"('"+row[0].replace('-','')+"','"+row[1].replace("'","")+"',"+str(row[3])+","+str(row[4])+","+str(row[5])+","+str(row[6])+","+str(row[7])+\
        ","+row[8]+","+row[9]+","+str(row[10])+","+str(row[11])+","+str(row[12])+","+str(row[13])+","+str(row[14])+");"
        try:
            #print(sql)
            cursor.execute(sql)
            db.commit()
        except:
            db.rollback()
db.close()