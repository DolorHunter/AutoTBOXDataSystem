import os
import requests
from bs4 import BeautifulSoup as bs
from datetime import datetime

user_agent = 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'
base_url = 'https://www.cars-data.com'
page_url = 'https://www.cars-data.com/en/all-cars/page1.html'
filename = '../data/car.csv'


def get_html(url):
    headers = {
        'User-Agent': user_agent,
    }
    session = requests.Session()
    response = session.get(url, headers=headers)
    response.text.encode('utf-8')
    if response.status_code != 200:
        print('Error: Response code' + str(response.status_code))
    else:
        return response.text


def get_car_data(url):
    raw_html = get_html(url)
    if isinstance(raw_html, str):
        data = []
        soup = bs(raw_html, 'html.parser')
        car_name = soup.find(class_="col-10")
        car_name = car_name.find("h1")
        data.append("".join(car_name))
        car_data = soup.find(class_="col-7")
        car_data = car_data.find_all(class_="row box")
        # GENERAL car_data[0]
        general_data = car_data[0].find_all("dd", class_="col-6")
        # 8 elem
        for elem in general_data:
            data.append("".join(elem).replace(",", "."))

        # DRIVE car_data[1]
        drive_data = car_data[1].find_all("dd", class_="col-6")
        # 5 elem
        for elem in drive_data:
            data.append("".join(elem).replace(",", "."))

        # FUEL ENGINE car_data[2]
        fuel_engine = car_data[2].find_all("dd", class_="col-6")
        # 14 elem
        for elem in fuel_engine:
            data.append("".join(elem).replace(",", "."))

        # ELECTROMOTOR car_data[3]
        electromotor = car_data[3].find_all("dd", class_="col-6")
        # 9 elem
        for elem in electromotor:
            data.append("".join(elem).replace(",", "."))

        # PERFORMANCE car_data[4]
        performance = car_data[4].find_all("dd", class_="col-6")
        # 12 elem
        for elem in performance:
            data.append("".join(elem).replace(",", "."))

        # CHASSIS car_data[5]
        chassis = car_data[5].find_all("dd", class_="col-6")
        # 11 elem
        for elem in chassis:
            data.append("".join(elem).replace(",", "."))

        # TRANSMISSION car_data[6]
        transmission = car_data[6].find_all("dd", class_="col-6")
        # 12 elem
        for elem in transmission:
            data.append("".join(elem).replace(",", "."))

        # SERVICE AND WARRANTY car_data[7]
        service_and_warranty = car_data[7].find_all("dd", class_="col-6")
        # 3 elem
        for elem in service_and_warranty:
            data.append("".join(elem).replace(",", "."))
        return data


def get_type_in_model(url):
    raw_html = get_html(url)
    if isinstance(raw_html, str):
        soup = bs(raw_html, 'html.parser')
        model_types = soup.find("div", class_="col-8")
        model_types = model_types.find_all("div", class_="row")
        types_url = []
        for model_type in model_types:
            type_url = model_type.find("a")['href'] + '/tech'
            types_url.append(type_url)
        return types_url


def get_current_page_models(url):
    raw_html = get_html(url)
    if isinstance(raw_html, str):
        soup = bs(raw_html, 'html.parser')
        models = soup.find("section", class_="models")
        models = models.find_all("div", class_="col-4")
        models_url = []
        for model in models:
            url = model.find("a")['href']
            models_url.append(url)
        return models_url


def write_line(line):
    if not os.path.exists(filename):
        with open(filename, 'a+', encoding="utf-8") as file:
            file.write(
                "car_name,price,periodical_technical_inspection,road_tax3months,car_body,transmission,seats_number,first_year_of_production,last_year_of_production,drive,engine_type,fuel,total_maximum_power,total_maximum_torque,cylinders_number,cylinder_valves,cylinder_capacity,borexstroke,compression_ratio,max_power,max_powerrpm,max_torque,max_torquerpm,fuel_system,valve_control,turbo,catalyst,fuel_tank,electro_engine_type,electro_max_power,electro_max_torque,electro_engines_number,battery_type,battery_capacity,battery_voltage,battery_range,power_consumption,top_speed,acceleration,city_consumption,city_consumptionkm,extra_urban_consumption,extra_urban_consumptionkm,combined_consumption,combined_consumptionkm,consumption_monitor,consumption_monitorkm,co2emissions,energy_label,front_wheel_suspension,rear_wheel_suspension,front_suspension,rear_suspension,front_stabilizer,rear_stabilizer,front_brakes,rear_brakes,front_tire_size,rear_tire_size,turning_radius,_1st_gear,_2nd_gear,_3rd_gear,_4th_gear,_5th_gear,_6th_gear,_7th_gear,_8th_gear,_9th_gear,reverse_gear,final_transmission,rpmat120kmh,maintenance,general_warranty,chassisWarranty,image," +
                "is_actived,is_deleted,created_by,last_updated_by,created_date,last_updated_date" + "\n")
            now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            file.write(line + ",1,0,db,db," + now + "," + now + "\n")
    else:
        with open(filename, 'a+', encoding="utf-8") as file:
            now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            file.write(line + ",1,0,db,db," + now + "," + now + "\n")


if __name__ == '__main__':
    for i in range(1, 92):
        cur_page_url = page_url.replace("page1", "page" + str(i))
        cur_page_models_url = get_current_page_models(cur_page_url)
        for model_url in cur_page_models_url:
            model_types_url = get_type_in_model(model_url)
            for model_type_url in model_types_url:
                print(i, model_type_url)
                car_data = get_car_data(model_type_url)
                write_line(",".join(car_data))
