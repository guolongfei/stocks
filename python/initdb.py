import urllib
import re
import os
import pandas as pd
html=urllib.urlopen('http://quote.eastmoney.com/stocklist.html').read()
p=re.compile('<a target="_blank" href="http://quote.eastmoney.com/..(\d*).html')
codes=p.findall(html)
code=[]
for item in codes:
    if item[0]=='6':
        code.append(item)
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