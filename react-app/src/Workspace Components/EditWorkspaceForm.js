import React, {useRef} from "react";

function EditWorkspaceForm(props){
    const titleRef = useRef();
    const descriptionRef = useRef();

    function EditWorkspacehandler(event){
        event.preventDefault();

        const title = titleRef.current.value;
        const description = descriptionRef.current.value;
        const renew = {title, description};
        props.EditWorkspace(renew);
    }

    return(
        <form on onSubmit={EditWorkspacehandler}>
            <p id="demo">New Workspace title</p>
            <input type={"text"} required placeholder="Title"ref={titleRef}/>
            <p id="demo">New Description</p>
            <input type={"text"} required placeholder="Description"ref={descriptionRef}/>
            <button>Submit</button>
        </form>
    );
}
export default EditWorkspaceForm;