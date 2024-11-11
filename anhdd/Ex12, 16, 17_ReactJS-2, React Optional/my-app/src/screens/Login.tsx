import React, {useState} from 'react';

type LoginProps = {
    login: () => void;
 }

export default function Login(props: LoginProps){
    const [username, setUsername] = useState<String>("");
    const [password, setPassword] = useState<String>("");
    const [valid, setValid] = useState<Boolean | null>(null);

    const handleLogin = () => {
        if ((username === 'admin') && (password === '00000')) {
            setValid(true);
            props.login();
        }
        else setValid(false);
    }

      return(
        <div id="login-background">
            <div id="loginform">
                <h2 id="headerTitle">Login</h2>

                <p style={{color: '#757575', margin: 0, padding: 0, alignSelf: 'start', paddingLeft: '50px'}}>Username/password: admin/00000</p> 
                <div>
                    <div className="row-login">
                        <label>Username</label>
                        <input type="text" placeholder="Enter your username" onChange={e => setUsername(e.target.value)}/>
                    </div>  
                </div>

                <div>
                    <div className="row-login">
                        <label>Password</label>
                        <input type="password" placeholder="Enter your password" onChange={e => setPassword(e.target.value)}/>
                    </div>  
                </div>

                <div style={{textAlign: 'center', position: 'relative'}}>
                {(valid===false)&&<p style={{color: 'red', margin: 0, padding: 0, fontSize: '14px', position: 'absolute', marginTop: '20px'
                            ,marginLeft: 'auto', marginRight: 'auto', left: 0, right: 0}}>Username hoặc password không hợp lệ</p>}
                </div> 
                <div id="button" className="row-login">
                    <button onClick={handleLogin}>Log in</button>
                </div>
            </div>
        </div>
      )
    }
    
  
  