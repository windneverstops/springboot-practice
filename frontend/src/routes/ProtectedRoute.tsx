import { Navigate, RouteProps } from "react-router";
import { useAuth } from "../providers/auth";

const ProtectedRoute = ({ children }: RouteProps) => {
  const { isAuthenticated } = useAuth();

  if (!isAuthenticated) {
    return <Navigate to="/login" />;
  }
  return <>{children}</>;
};

export default ProtectedRoute;
