import React from "react";
import md5 from 'js-md5';
import axios from 'axios';

var UserStateContext = React.createContext();
var UserDispatchContext = React.createContext();

function userReducer(state, action) {
  switch (action.type) {
    case "LOGIN_SUCCESS":
      return { ...state, isAuthenticated: true };
    case "LOGIN_FAILURE":
      return { ...state, isAuthenticated: false };
    case "SIGN_OUT_SUCCESS":
      return { ...state, isAuthenticated: false };
    case "REGISTER_SUCCESS":
      return { ...state, isAuthenticated: false };
    case "REGISTER_FAILURE":
      return { ...state, isAuthenticated: false };
    default: {
      throw new Error(`Unhandled action type: ${action.type}`);
    }
  }
}

function UserProvider({ children }) {
  var [state, dispatch] = React.useReducer(userReducer, {
    isAuthenticated: !!localStorage.getItem("id_token"),
  });

  return (
    <UserStateContext.Provider value={state}>
      <UserDispatchContext.Provider value={dispatch}>
        {children}
      </UserDispatchContext.Provider>
    </UserStateContext.Provider>
  );
}

function useUserState() {
  var context = React.useContext(UserStateContext);
  if (context === undefined) {
    throw new Error("useUserState must be used within a UserProvider");
  }
  return context;
}

function useUserDispatch() {
  var context = React.useContext(UserDispatchContext);
  if (context === undefined) {
    throw new Error("useUserDispatch must be used within a UserProvider");
  }
  return context;
}

export { UserProvider, useUserState, useUserDispatch, loginUser, signOut, registerUser };

// ###########################################################
function loginUser(dispatch, name, password, history, setIsLoading, setError) {
  setError(false);
  setIsLoading(true);
  password = md5.hex(password);

  if (!!name && !!password) {
    var loginData = { 
      username : name,
      password : password
    }
  
    axios.post('/User/login', loginData)
      .then(res => {
        if (res.request.response === "Succeed."){
          setTimeout(() => {
            localStorage.setItem('id_token', 1)
            setError(null)
            setIsLoading(false)
            dispatch({ type: 'LOGIN_SUCCESS' })
            history.push('/app/dashboard')
          }, 300);
        }
        else{
          alert(res.request.response);
        }
      })   

      axios.post('/User/searchUserByUsername', {username: name})
      .then(res => {
        if (res.status === 200 && Object.keys(res.request.response).length > 0){
          setTimeout(() => {
            const data = JSON.parse(res.request.response);
            localStorage.setItem('user', JSON.stringify(data));
          }, 300);
        }
      })   
  } 
  dispatch({ type: "LOGIN_FAILURE" });
  setError(true);
  setIsLoading(false);
}

function signOut(dispatch, history) {
  localStorage.removeItem("id_token");
  localStorage.removeItem("user");
  dispatch({ type: "SIGN_OUT_SUCCESS" });
  history.push("/login");
}

function registerUser(dispatch, name, email, password, history, setIsLoading, setError) {
  setError(false);
  setIsLoading(true);

  if (!!email && !!name && !!password) {
    var registerData = { 
      email : email,
      username : name,
      password : password,
      createdBy : name,
      lastUpdatedBy : name
    }
  
    axios.post('/User/register', registerData)
      .then(res => {
        if (res.request.response === "Succeed."){
          setTimeout(() => {
            setError(null)
            setIsLoading(false)
            dispatch({ type: 'REGISTER_SUCCESS' })
            history.push('/login')
          }, 300);
        }
        else{
          alert(res.request.response);
        }

      })    
  } 
  dispatch({ type: "REGISTER_FAILURE" });
  setError(true);
  setIsLoading(false);
}
