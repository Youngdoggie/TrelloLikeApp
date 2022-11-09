import {Link} from "react-router-dom";
import {Button} from "@mui/material";
import {useHistory} from "react-router-dom"

function HomePage(){
    return(
        console.log(localStorage.getItem("userID")),
        <div class="text-center margin5">
            <h1>Welcome to Home Page</h1>
            <form>
                <button id="home-button">
                    <Link to='/Createworkspace' style={{textDecoration: 'none', color:'white'}}>
                    Create your workspace
                    </Link> 
                </button><br></br>
                <br></br>
                <button id="home-button">
                    <Link to='/workspace' style={{textDecoration: 'none', color:'white'}}>
                    View my workspace
                    </Link>
                </button>
            </form>
        </div>
    );
}

export default HomePage;
