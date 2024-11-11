import React, {useState} from 'react';
import Login from "./screens/Login";
import CatPage from './screens/CatPage';
import './App.css';

function App() {
  const [isLogin, setIsLogin] = useState<Boolean>(false);

  const login = () => {
    setIsLogin(true);
  }

  const logout = () => {
    setIsLogin(false);
  }
  return (
    <>
        {isLogin?<CatPage logout={logout}/>:<Login login={login} />}
    </>
  );
}

export default App;
