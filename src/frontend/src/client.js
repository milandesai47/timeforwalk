import fetch from 'unfetch';
import {errorNotification, successNotification} from "./Notification";

const checkStatus = response => {
  if (response.ok) {
    return response;
  }
  // convert non-2xx HTTP responses into errors:
  const error = new Error(response.statusText);
  error.response = response;
  return Promise.reject(error);
}

const checkCity = response => {
  if (response.ok) {
    return response;
  }
  // convert non-2xx HTTP responses into errors:
  const error = new Error(response.statusText);
  error.response = response;
  return Promise.reject(error);
}
export const getUsersCount = () =>
    fetch("api/v1/users/count")
    .then(checkStatus);

export const getAllUsers = () =>
    fetch("api/v1/users")
    .then(checkStatus);

export const getAllCities = () =>
    fetch("api/v1/city")
    .then(checkCity);

export const addUserUser = user =>
    fetch("api/v1/users", {
      headers :{
        'Content-Type': 'application/json'
      },
      method: 'POST',
      body: JSON.stringify(user)
    }).then(checkStatus);

export const deleteUser = email =>
    fetch("api/v1/users",{
      headers: {'Content-Type': 'application/json'},
      method: 'DELETE',
      body: JSON.stringify(email)
    }).then(checkStatus)


