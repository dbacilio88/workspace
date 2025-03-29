import {Template} from "../../layout/common/template.type";

export type Scheme = 'auto' | 'dark' | 'light';
export type Theme = 'default' | string;

export interface AppConfig {
  template: Template;
  scheme: Scheme;
  theme: Theme;
}

export const appConfig: AppConfig = {
  template: 'basic',
  scheme: 'light',
  theme: 'default'
};
