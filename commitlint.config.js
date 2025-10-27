module.exports = {
  extends: ['@commitlint/config-conventional'],
  ignores: [
    (message) =>
      message.startsWith('Merge ') ||
      message.match(/^Create /) || // allow old "Create ..." commits
      message.match(/^Add /)       // allow old "Add ..." commits
  ],
};
