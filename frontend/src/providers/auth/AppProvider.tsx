import { createContext, ReactNode, useState } from "react";

interface AppProviderProps {
  children: ReactNode;
}

interface ContextTypes {
  isAuthenticated: boolean;
}

const AppContext = createContext<ContextTypes | undefined>(undefined);

const AppProvider = ({ children }: AppProviderProps) => {
  const [isAuthenticated] = useState<boolean>(false);

  return (
    <AppContext.Provider value={{ isAuthenticated }}>
      {children}
    </AppContext.Provider>
  );
};

export { AppContext, AppProvider };
