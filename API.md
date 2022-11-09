# API calls

## User management 

#### POST /user/register
Register user

JSON:

    {
        "email":"{email here}",
        "password":"{password here}",
        "question":"{question here}",
        "answer":"{answer here}"
    }

Returns: 

true if registered successfuly

false if not registered 

#### POST /user/login
Log in user

JSON:

    {
        "email":"{email here}",
        "password":"{password here}"
    }

Returns: user object

#### PUT /user/forgot
Update password

JSON:

    {
        "email":"{email here}",
        "answer":"{answer here}",
        "newPass":"{new password here}"
    }

Returns: user object

#### GET /user/{Workspace ID}
Get specific workspace that a user belongs to

JSON:
none

Returns: user object

## Workspace management

#### GET /workspace/{Workspace ID}
Get all info about workspace

JSON:
none

Returns: workspace object

#### GET /workspace/user/{User ID}
Get all workspace user is a part of

JSON:
none

Returns: json object with list of workspaces 

#### POST /workspace/create
Create workspace

JSON:

    {
        "title":"{workspace title}",
        "description":"{workspace description}",
        "user_id":"{user id of user who created workspace}"
    }

Returns: workspace object

#### PUT /workspace/{workspace ID}
Update workspace title and description 

JSON:

    {
        "title":"{new workspace title}",
        "descripton":"{new description}"
    }

Returns: workspace

#### PATCH /workspace/{workspace ID}
Add user to workspace

JSON:

    {
        "email":"{email of user to be added}"
    }

Returns: workspace

#### POST /workspace/{workspace ID}
Add board to workspace

JSON:

    {
        "title":"{board title}"
    }

Returns: workspace

#### DELETE /workspace/{workspace ID}/{board ID}
Delete board

JSON: none

Returns: workspace

## Board management

#### GET /board/{board ID}
Get board info

JSON: none

Returns: board
