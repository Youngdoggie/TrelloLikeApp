import {useHistory} from "react-router-dom"
import EditWorkspaceForm from "../Workspace Components/EditWorkspaceForm";
import { useLocation } from 'react-router-dom';

function EditWorkspacePage(){
    const history = useHistory();
    const location = useLocation();
    let userIdVal = localStorage.getItem("userID");

    function EditWorkspacehandler(renew){
        fetch(`http://localhost:8080/workspace/${location.state.data}`,{
            method: 'PUT',
            body: JSON.stringify(renew),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(()=> history.replace('/workspace'));
    }


    return(
        <div>
            <EditWorkspaceForm EditWorkspace={EditWorkspacehandler}/>
        </div>

    );
}

export default EditWorkspaceForm;