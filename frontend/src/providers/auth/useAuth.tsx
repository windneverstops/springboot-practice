import { useContext } from "react";
import { AppContext } from "./AppProvider";

const useAuth = () => {
  const context = useContext(AppContext);
  if (context === undefined) {
    throw new Error("useAuth must be used within a AppProvider");
  }
  return context;
};

export default useAuth;
