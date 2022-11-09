import {useHistory} from "react-router-dom"
import RegisterForm from "../Components/RegisterForm"

function RegisterPage(){

    const history = useHistory();

    function registerUserHandler(user){
        fetch('http://localhost:8080/user/register',{
           method: 'POST',
           body: JSON.stringify(user),
           headers: {
                'Content-Type': 'application/json'
           }
        }).then(()=> history.replace('/login'));
    }

    return(
        <div class="text-center margin5">
            <h1>Registration Page</h1>
            <RegisterForm registerUser = {registerUserHandler}/>
        </div>
    );
}

export default RegisterPage;
