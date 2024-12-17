import { Route, Routes } from "react-router";
import "./App.css";

import { Login, Register } from "./pages/Auth";
import Home from "./pages/Home";
import { AppProvider } from "./providers/auth";
import ProtectedRoute from "./routes/ProtectedRoute";

function App() {
  return (
    <>
      <AppProvider>
        <Routes>
          <Route
            index
            element={
              <ProtectedRoute>
                <Home />
              </ProtectedRoute>
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="*" element={<div>404</div>} />
        </Routes>
      </AppProvider>
    </>
  );
}

export default App;
