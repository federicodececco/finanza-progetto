
SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
  (1, 'Markets', 'Types of financial markets'),
  (2, 'Investment Vehicles', 'Various instruments for investing capital'),
  (3, 'Banking Products', 'Bank account and loan products'),
  (4, 'Financial Statements', 'Summaries of financial performance'),
  (5, 'Insurance', 'Risk management products');

INSERT INTO `tags` (`id`, `name`) VALUES
  (1, 'Risk'),
  (2, 'Liquidity'),
  (3, 'Equity'),
  (4, 'Debt'),
  (5, 'ROI'),
  (6, 'Interest'),
  (7, 'Asset'),
  (8, 'Liability'),
  (9, 'Volatility'),
  (10, 'Dividend');

INSERT INTO `concepts` (`id`, `category_id`, `img_url`, `name`, `description`, `level`) VALUES
  (1, 1, NULL, 'Stock', 'Ownership share in a company', 'BEGINNER'),
  (2, 1, NULL, 'Bond', 'Debt instrument issued by governments or corporations', 'BEGINNER'),
  (3, 1, NULL, 'Option', 'Contract giving the right, but not obligation, to buy or sell an asset', 'INTERMEDIATE'),
  (4, 1, NULL, 'Future', 'Standardized contract to buy or sell an asset at a predetermined price and date', 'INTERMEDIATE'),
  (5, 2, NULL, 'Mutual Fund', 'Pool of funds collected from investors to invest in securities', 'BEGINNER'),
  (6, 2, NULL, 'ETF', 'Exchange-traded fund traded like a stock', 'BEGINNER'),
  (7, 2, NULL, 'Hedge Fund', 'Alternative investment using pooled funds to earn active return', 'HARD'),
  (8, 3, NULL, 'Savings Account', 'Bank account that earns interest on deposits', 'BEGINNER'),
  (9, 3, NULL, 'Mortgage', 'Loan secured by real property', 'INTERMEDIATE'),
  (10, 3, NULL, 'Credit Card', 'Revolving line of credit issued by a financial institution', 'BEGINNER'),
  (11, 4, NULL, 'Balance Sheet', 'Statement of assets, liabilities, and equity at a point in time', 'INTERMEDIATE'),
  (12, 4, NULL, 'Income Statement', 'Report of revenue and expenses over a period', 'INTERMEDIATE'),
  (13, 4, NULL, 'Cash Flow Statement', 'Report of cash inflows and outflows over a period', 'INTERMEDIATE'),
  (14, 5, NULL, 'Life Insurance', 'Contract that pays a sum on death of the insured', 'BEGINNER'),
  (15, 5, NULL, 'Liability Insurance', 'Insurance that protects against claims resulting from injuries and damage', 'INTERMEDIATE');

INSERT INTO `concept_tag` (`concept_id`, `tag_id`) VALUES
  (1, 3),
  (2, 4),
  (3, 9),
  (4, 9),
  (5, 5),
  (6, 2),
  (7, 9),
  (8, 2),
  (9, 4),
  (10, 6),
  (11, 7),
  (12, 5),
  (13, 2),
  (14, 1),
  (15, 8);

SET FOREIGN_KEY_CHECKS = 1;
