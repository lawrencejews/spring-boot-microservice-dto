import React, { Component } from 'react'
import EmployeeService from '../service/EmployeeService'

class EmployeeComponent extends Component {

  constructor(props) {
    super(props)

    this.state = {
      employee: {},
      department: {},
      organisation: {}
    }
  }

  componentDidMount() {
    EmployeeService.getEmployee().then((response) => {
      this.setState({ employee: response.data.employee })
      this.setState({ department: response.data.department })
      this.setState({ organisation: response.data.organisation })

      console.log(this.state.employee)
      console.log(this.state.department)
      console.log(this.state.organisation)
    })
  }

  render() {
    return (
      <div><br/>
        <div className='card col-md-6  offset-md-3'>
          <h3 className='text-center card-header'>View Employee Details</h3>
          <div className='card-body'>
            <div className='row'>
              <p><strong>Employee First Name</strong> { this.state.employee.firstName}</p>
            </div>
            <div className='row'>
              <p><strong>Employee Last Name</strong> {this.state.employee.lastName}</p>
            </div>
            <div className='row'>
              <p><strong>Employee Email</strong> {this.state.employee.email}</p>
            </div>
          </div>
          <h3 className='text-center card-header'>View Department Details</h3>
          <div className='card-body'>
            <div className='row'>
              <p><strong>Department Name</strong> {this.state.department.departmentName}</p>
            </div>
            <div className='row'>
              <p><strong>Department Description</strong> {this.state.department.departmentDescription}</p>
            </div>
            <div className='row'>
              <p><strong>Department code</strong> {this.state.department.departmentCode}</p>
            </div>
          </div>
          {/* <h3 className='text-center card-header'>View Organisation Details</h3>
          <div className='card-body'>
            <div className='row'>
              <p><strong>Organisation Name</strong> {this.state.organisation.organisationName}</p>
            </div>
            <div className='row'>
              <p><strong>Organisation Description</strong> {this.state.organisation.organisationDescription}</p>
            </div>
            <div className='row'>
              <p><strong>Organisation code</strong> {this.state.organisation.organisationCode}</p>
            </div>
          </div> */}
        </div>
      </div>
    )
  }
}

export default EmployeeComponent;
