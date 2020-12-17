# CarCrawlers

[![LICENSE](https://img.shields.io/badge/License-MIT-%23FF4D5B.svg?style=flat-square)](https://github.com/DolorHunter/AutoTBOXDataSystem/blob/master/LICENSE)
[![Python](https://img.shields.io/badge/Python-v3.9.0-blue.svg?style=flat-square)](https://github.com/DolorHunter/1p3aMSCSAdminReport/releases)
[![BeautifulSoup](https://img.shields.io/badge/BeautifulSoup-v4.9.3-yellow.svg?style=flat-square)](https://github.com/DolorHunter/1p3aMSCSAdminReport/releases)

## Info

* Data source from [cars-data.com](https://www.cars-data.com)
* Crawler [src/main.py](src/main.py)
* Data [data/car.csv](src/car.csv)

## Requirements

Python 3

```plain
$ pip install os requests beautifulsoup4
```

## About CarCrawlers

* [cars-data.com](https://www.cars-data.com) seems not to have crawler protection, and the format is easy to crawl. Have fun crawling.
* [data/car.csv](src/car.csv) only includes data from page1~page36 and it stoped at [Mercedes E 220 CDI Classic tech specs](https://www.cars-data.com/en/mercedes-e-220-cdi-classic-specs/24161/tech), which is at [page36](https://www.cars-data.com/en/all-cars/page36.html), model [2006 Mercedes-Benz E-class specs](https://www.cars-data.com/en/mercedes-benz-e-class-2006/1503), type [2006 Mercedes E 220 CDI Classic  170 hp, diesel, 6 s., manual](https://www.cars-data.com/en/mercedes-e-220-cdi-classic-specs/24161/tech).
* I think it is bad connection cause this error. __[Full Tracker Info](#Traceback-Info)__ is down below, and there is a __[Brief Traceback](#Brief-Traceback)__ for you.

### Brief Traceback

```javascript
urllib3.exceptions.MaxRetryError: HTTPSConnectionPool(host='www.cars-data.com', port=443): Max retries exceeded with url: /en/mercedes-e-220-cdi-classic-specs/24161/tech (Caused by SSLError(SSLEOFError(8, 'EOF occurred in violation of protocol (_ssl.c:1122)')))

& 

requests.exceptions.SSLError: HTTPSConnectionPool(host='www.cars-data.com', port=443): Max retries exceeded with url: /en/mercedes-e-220-cdi-classic-specs/24161/tech (Caused by SSLError(SSLEOFError(8, 'EOF occurred in violation of protocol (_ssl.c:1122)')))
```

### Traceback Info

```javascript
Traceback (most recent call last):
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\connectionpool.py", line 667, in urlopen
    self._prepare_proxy(conn)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\connectionpool.py", line 932, in _prepare_proxy
    conn.connect()
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\connection.py", line 362, in connect
    self.sock = ssl_wrap_socket(
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\util\ssl_.py", line 386, in ssl_wrap_socket
    return context.wrap_socket(sock, server_hostname=server_hostname)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\ssl.py", line 500, in wrap_socket
    return self.sslsocket_class._create(
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\ssl.py", line 1040, in _create
    self.do_handshake()
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\ssl.py", line 1309, in do_handshake
    self._sslobj.do_handshake()
ssl.SSLEOFError: EOF occurred in violation of protocol (_ssl.c:1122)

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\requests\adapters.py", line 439, in send
    resp = conn.urlopen(
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\connectionpool.py", line 726, in urlopen
    retries = retries.increment(
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\urllib3\util\retry.py", line 446, in increment
    raise MaxRetryError(_pool, url, error or ResponseError(cause))
urllib3.exceptions.MaxRetryError: HTTPSConnectionPool(host='www.cars-data.com', port=443): Max retries exceeded with url: /en/mercedes-e-220-cdi-classic-specs/24161/tech (Caused by SSLError(SSLEOFError(8, 'EOF occurred in violation of protocol (_ssl.c:1122)')))

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "D:\*\AutoTBOXDataSystem\CarCrawlers\src\main.py", line 137, in <module>
    car_data = get_car_data(model_type_url)
  File "D:\*\AutoTBOXDataSystem\CarCrawlers\src\main.py", line 26, in get_car_data
    raw_html = get_html(url)
  File "D:\*\AutoTBOXDataSystem\CarCrawlers\src\main.py", line 17, in get_html
    response = session.get(url, headers=headers)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\requests\sessions.py", line 543, in get
    return self.request('GET', url, **kwargs)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\requests\sessions.py", line 530, in request
    resp = self.send(prep, **send_kwargs)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\requests\sessions.py", line 643, in send
    r = adapter.send(request, **kwargs)
  File "C:\Users\*\AppData\Local\Programs\Python\Python39\lib\site-packages\requests\adapters.py", line 514, in send
    raise SSLError(e, request=request)
requests.exceptions.SSLError: HTTPSConnectionPool(host='www.cars-data.com', port=443): Max retries exceeded with url: /en/mercedes-e-220-cdi-classic-specs/24161/tech (Caused by SSLError(SSLEOFError(8, 'EOF occurred in violation of protocol (_ssl.c:1122)')))

Process finished with exit code 1
```
