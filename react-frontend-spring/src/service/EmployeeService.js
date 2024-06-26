import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/api/employees';

const EMPLOYEE_ID = 3;

class EmployeeService{
  getEmployee() {
    return axios.get(EMPLOYEE_SERVICE_BASE_URL + '/' + EMPLOYEE_ID);

  }
}

// eslint-disable-next-line import/no-anonymous-default-export
export default new EmployeeService();