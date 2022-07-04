import React from "react";

function Login() {
    return (
        <div className="login-page">
            <h2>Login In</h2>
            <form autoComplete="off">
                <div className="form-group">
                    <input
                        type="email"
                        className="form-control"
                        id="Email"
                        aria-describedby="emailHelp"
                        placeholder="Enter email"
                    />
                </div>
                <div className="form-group">
                    <input
                        type="password"
                        autoComplete="new-password"
                        className="form-control"
                        id="Password"
                        placeholder="Password"
                    />
                </div>
                <button type="submit" className="btn">
                    Submit
                </button>
            </form>
        </div>
    );
}

export default Login;

