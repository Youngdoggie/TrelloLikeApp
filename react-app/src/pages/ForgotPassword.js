import {useHistory} from "react-router-dom"
import ForgotPasswordForm from "../Components/ForgotPasswordForm";
function ForgotPasswordPage(){
    
    const history = useHistory();

    function ForgotPasswordhandler(user){
        fetch('')
            .then(()=>{
                history.replace('/home')});
        fetch('http://localhost:8080/user/forgot',{
           method: 'PUT',
           body: JSON.stringify(user),
           headers: {
                'Content-Type': 'application/json'
           }
        }).then(()=> history.replace('/login'));
    }


    return(
        <div class="text-center margin5">
            <h1>Trouble Logging In?</h1>
            <ForgotPasswordForm ForgotPassword={ForgotPasswordhandler}/>
        </div>

    );
}

export default ForgotPasswordPage;
